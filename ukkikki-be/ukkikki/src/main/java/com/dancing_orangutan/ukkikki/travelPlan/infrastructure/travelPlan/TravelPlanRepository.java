package com.dancing_orangutan.ukkikki.travelPlan.infrastructure.travelPlan;

import com.dancing_orangutan.ukkikki.entity.info.CityEntity;
import com.dancing_orangutan.ukkikki.global.error.ApiException;
import com.dancing_orangutan.ukkikki.global.error.ErrorCode;
import com.dancing_orangutan.ukkikki.member.domain.MemberEntity;
import com.dancing_orangutan.ukkikki.member.infrastructure.MemberFinder;
import com.dancing_orangutan.ukkikki.travelPlan.domain.keyword.KeywordEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.*;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.city.CityFinder;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.keyword.KeywordFinder;

import java.util.List;

import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.memberTravelPlan.MemberTravelPlanFinder;
import com.dancing_orangutan.ukkikki.travelPlan.mapper.MemberTravelPlanMapper;
import com.dancing_orangutan.ukkikki.travelPlan.mapper.TravelPlanMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
@Slf4j
public class TravelPlanRepository {

	private final JpaTravelPlanRepository jpaTravelPlanRepository;

	private final QueryDslTravelPlanRepository queryDslTravelPlanRepository;

	private final CityFinder cityFinder;

	private final KeywordFinder keywordFinder;

	private final MemberFinder memberFinder;

	private final TravelPlanMapper travelPlanMapper;

	private final MemberTravelPlanFinder memberTravelPlanFinder;

	private final MemberTravelPlanMapper memberTravelPlanMapper;

	public TravelPlan save(final TravelPlan travelPlanDomain) {

		CityEntity arrivalCity = cityFinder.getReferenceById(
				travelPlanDomain.travelPlanInfo().arrivalCityId());
		CityEntity departureCity = cityFinder.getReferenceById(
				travelPlanDomain.travelPlanInfo().departureCityId());
		List<KeywordEntity> keywords = travelPlanDomain
				.travelPlanInfo()
				.keywords()
				.stream()
				.map(keywordFinder::getReferenceById)
				.toList();
		MemberEntity member = memberFinder.getReferenceById(travelPlanDomain.getHost().memberId());

		TravelPlanEntity travelPlanEntity = TravelPlanEntity.builder()
				.name(travelPlanDomain.travelPlanInfo().name())
				.arrivalCity(arrivalCity)
				.departureCity(departureCity)
				.name(travelPlanDomain.travelPlanInfo().name())
				.startDate(travelPlanDomain.travelPlanInfo().startDate())
				.endDate(travelPlanDomain.travelPlanInfo().endDate())
				.planningStatus(travelPlanDomain.travelPlanInfo().planningStatus())
				.minPeople(travelPlanDomain.travelPlanInfo().minPeople())
				.maxPeople(travelPlanDomain.travelPlanInfo().maxPeople())
				.keywords(keywords)
				.memberId(member.getMemberId())
				.adultCount(travelPlanDomain.getHost().adultCount())
				.infantCount(travelPlanDomain.getHost().infantCount())
				.childCount(travelPlanDomain.getHost().childCount())
				.build();

		travelPlanEntity.addTravelKeywords(keywords);
		travelPlanEntity.addMemberTravelPlan(member,
				travelPlanDomain.getHost().adultCount(), travelPlanDomain.getHost().childCount(),
				travelPlanDomain.getHost().infantCount(), true);

		TravelPlanEntity entity = jpaTravelPlanRepository.save(travelPlanEntity);

		return travelPlanMapper.entityToDomain(entity);
	}

	public void joinTravelPlan(final TravelPlan travelPlanDomain) {
		TravelPlanEntity travelPlan = jpaTravelPlanRepository.findById(
						travelPlanDomain.travelPlanInfo().travelPlanId())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
		MemberEntity memberEntity = memberFinder.getById(travelPlanDomain.getHost().memberId());

		travelPlan.addMemberTravelPlan(memberEntity, travelPlanDomain.getHost().adultCount(),
				travelPlanDomain.getHost().childCount(), travelPlanDomain.getHost().infantCount(),
				false);
	}

	public TravelPlanRead findAllByTravelPlanId(final Integer travelPlanId,
			final Integer memberId) {
		TravelPlanEntity travelPlanEntity = jpaTravelPlanRepository.findAllByTravelPlanId(
				travelPlanId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
		return TravelPlanRead.fromEntity(travelPlanEntity, memberId);
	}

	public List<TravelPlan> searchTravelPlan(final TravelPlan travelPlanDomain) {
		List<TravelPlanEntity> travelPlanEntities = queryDslTravelPlanRepository.searchTravelPlan(
				travelPlanDomain.travelPlanInfo().startDate(),
				travelPlanDomain.travelPlanInfo().endDate(),
				travelPlanDomain.travelPlanInfo().departureCityId(),
				travelPlanDomain.travelPlanInfo().arrivalCityId(),
				travelPlanDomain.travelPlanInfo().planningStatus(),
				travelPlanDomain.travelPlanInfo().keywords()
		);

		return travelPlanEntities.stream()
				.map(travelPlanMapper::entityToDomain)
				.toList();
	}

	public List<TravelPlan> fetchTravelPlans(final TravelPlan travelPlanDomain) {
		List<TravelPlanEntity> travelPlanEntities = queryDslTravelPlanRepository.fetchSuggestedTravelPlan(travelPlanDomain.travelPlanInfo().planningStatus());

		return travelPlanEntities.stream()
				.map(travelPlanMapper::entityToDomain)
				.toList();
	}

	public void updateTravelPlanStatus(final TravelPlan travelPlanDomain) {
		TravelPlanEntity travelPlanEntity = jpaTravelPlanRepository.findById(travelPlanDomain.travelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
        travelPlanEntity.updateStatus(travelPlanDomain.travelPlanInfo().planningStatus());
	}

	public void writeComment(final TravelPlan domain) {
		TravelPlanEntity entity = jpaTravelPlanRepository.findById(
						domain.travelPlanInfo().travelPlanId())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		entity.updateComment(domain.travelPlanInfo().hostComment());
	}

	public TravelPlan updateCloseTime(final TravelPlan domain) {
		TravelPlanEntity entity = jpaTravelPlanRepository.findById(
						domain.travelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		entity.updateCloseTime(domain.travelPlanInfo().closeTime());

		return travelPlanMapper.entityToDomain(entity);
	}

	public void updateCompanion(final TravelPlan domain) {
		TravelPlanEntity travelPlanEntity = jpaTravelPlanRepository.findById(
				domain.travelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		travelPlanEntity.updateHostInfo(domain.getHost().memberId(), domain.getHost().adultCount(), domain.getHost().childCount(), domain.getHost().infantCount());
	}

	public TravelPlan fetchTravelPlan(final TravelPlan domain) {
		TravelPlanEntity entity = findById(domain.travelPlanInfo().travelPlanId());
		return travelPlanMapper.entityToDomain(entity);
	}

	private TravelPlanEntity findById(final Integer id) {
		return jpaTravelPlanRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.TRAVEL_PLAN_NOT_FOUND));
	}
}
