package com.dancing_orangutan.ukkikki.travelPlan.infrastructure.travelPlan;

import com.dancing_orangutan.ukkikki.geography.domain.CityEntity;
import com.dancing_orangutan.ukkikki.member.domain.member.MemberEntity;
import com.dancing_orangutan.ukkikki.member.infrastructure.member.MemberFinder;
import com.dancing_orangutan.ukkikki.travelPlan.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.keyword.KeywordEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.*;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.city.CityFinder;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.keyword.KeywordFinder;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public TravelPlanEntity save(final TravelPlan travelPlanDomain) {

		CityEntity arrivalCity = cityFinder.getReferenceById(
				travelPlanDomain.getTravelPlanInfo().arrivalCityId());
		CityEntity departureCity = cityFinder.getReferenceById(
				travelPlanDomain.getTravelPlanInfo().departureCityId());
		List<KeywordEntity> keywords = travelPlanDomain
				.getTravelPlanInfo()
				.keywords()
				.stream()
				.map(keywordFinder::getReferenceById)
				.toList();
		MemberEntity member = memberFinder.getReferenceById(travelPlanDomain.getHost().memberId());

		TravelPlanEntity travelPlanEntity = TravelPlanEntity.builder()
				.name(travelPlanDomain.getTravelPlanInfo().name())
				.arrivalCity(arrivalCity)
				.departureCity(departureCity)
				.name(travelPlanDomain.getTravelPlanInfo().name())
				.startDate(travelPlanDomain.getTravelPlanInfo().startDate())
				.endDate(travelPlanDomain.getTravelPlanInfo().endDate())
				.planningStatus(travelPlanDomain.getTravelPlanInfo().planningStatus())
				.minPeople(travelPlanDomain.getTravelPlanInfo().minPeople())
				.maxPeople(travelPlanDomain.getTravelPlanInfo().maxPeople())
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

		return jpaTravelPlanRepository.save(travelPlanEntity);
	}

	public void joinTravelPlan(final TravelPlan travelPlanDomain) {
		TravelPlanEntity travelPlan = jpaTravelPlanRepository.findById(
						travelPlanDomain.getTravelPlanInfo().travelPlanId())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
		MemberEntity memberEntity = memberFinder.getById(travelPlanDomain.getHost().memberId());

		travelPlan.addMemberTravelPlan(memberEntity, travelPlanDomain.getHost().adultCount(),
				travelPlanDomain.getHost().childCount(), travelPlanDomain.getHost().infantCount(),
				false);
	}

	public TravelPlanEntity findAllByTravelPlanId(final Integer travelPlanId) {
        return jpaTravelPlanRepository.findAllByTravelPlanId(
                travelPlanId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
	}

	public List<TravelPlanEntity> searchTravelPlan(final TravelPlan travelPlanDomain) {
		return queryDslTravelPlanRepository.searchTravelPlan(
				travelPlanDomain.getTravelPlanInfo().startDate(),
				travelPlanDomain.getTravelPlanInfo().endDate(),
				travelPlanDomain.getTravelPlanInfo().departureCityId(),
				travelPlanDomain.getTravelPlanInfo().arrivalCityId(),
				travelPlanDomain.getTravelPlanInfo().planningStatus(),
				travelPlanDomain.getTravelPlanInfo().keywords()
		);
	}

	//TODO : 반복되는 코드 매퍼로 분리해야함
	public List<TravelPlan> fetchTravelPlans(final TravelPlan travelPlanDomain) {
		List<TravelPlanEntity> travelPlanEntities = queryDslTravelPlanRepository.fetchSuggestedTravelPlan(travelPlanDomain.getTravelPlanInfo().planningStatus());

		return travelPlanEntities.stream()
				.map(entity -> TravelPlan.builder()
						.travelPlanInfo(
								TravelPlanInfo.builder()
										.travelPlanId(entity.getTravelPlanId())
										.name(entity.getName())
										.startDate(entity.getStartDate())
										.endDate(entity.getEndDate())
										.departureCityId(entity.getDepartureCity().getCityId())
										.arrivalCityId(entity.getArrivalCity().getCityId())
										.planningStatus(entity.getPlanningStatus())
										.maxPeople(entity.getMaxPeople())
										.keywords(
												entity.getTravelPlanKeywords().stream()
														.map(keywordEntity -> keywordEntity.getKeyword().getKeywordId())
														.toList()
										)
										.build()
						)
						.host(
								Host.builder()
										.adultCount(entity.getMemberTravelPlans().
												stream()
												.mapToInt(MemberTravelPlanEntity::getAdultCount)
												.sum()
										).childCount(entity.getMemberTravelPlans().
												stream()
												.mapToInt(MemberTravelPlanEntity::getChildCount)
												.sum())
										.infantCount(entity.getMemberTravelPlans().
												stream()
												.mapToInt(MemberTravelPlanEntity::getInfantCount)
												.sum())
										.build()
						)
						.build()
				)
				.toList();
	}

	public void updateTravelPlanStatus(final TravelPlan travelPlanDomain) {
		TravelPlanEntity travelPlanEntity = jpaTravelPlanRepository.findById(travelPlanDomain.getTravelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));
        travelPlanEntity.updateStatus(travelPlanDomain.getTravelPlanInfo().planningStatus());
	}

	public void writeComment(final TravelPlan domain) {
		TravelPlanEntity entity = jpaTravelPlanRepository.findById(
						domain.getTravelPlanInfo().travelPlanId())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		entity.updateComment(domain.getTravelPlanInfo().hostComment());
	}

	public TravelPlan updateCloseTime(final TravelPlan domain) {
		TravelPlanEntity entity = jpaTravelPlanRepository.findById(
						domain.getTravelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		entity.updateCloseTime(domain.getTravelPlanInfo().closeTime());

		return TravelPlan.builder()
				.travelPlanInfo(TravelPlanInfo.builder().
						createTime(entity.getCreateTime())
						.closeTime(entity.getCloseTime())
						.build())
				.build();
	}

	public void updateHost(final TravelPlan domain) {
		TravelPlanEntity travelPlanEntity = jpaTravelPlanRepository.findById(
				domain.getTravelPlanInfo().travelPlanId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 여행 계획입니다."));

		travelPlanEntity.updateHostInfo(domain.getHost().memberId(), domain.getHost().adultCount(), domain.getHost().childCount(), domain.getHost().infantCount());
	}

	public Page<TravelPlanEntity> getAllTravelPlans(Pageable pageable) {
		return jpaTravelPlanRepository.findByPlanningStatusNot(PlanningStatus.CONFIRMED,pageable);
	}

	public TravelPlanEntity fetchTravelPlan(Integer travelPlanId) {
		return jpaTravelPlanRepository.findAllByTravelPlanId(travelPlanId).orElseThrow(() -> new IllegalArgumentException("존재 하지않는 여행계획입니다."));
	}
}
