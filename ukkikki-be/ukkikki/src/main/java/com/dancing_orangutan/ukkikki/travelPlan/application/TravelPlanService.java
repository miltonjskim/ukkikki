package com.dancing_orangutan.ukkikki.travelPlan.application;


import com.dancing_orangutan.ukkikki.event.eventPublisher.SpringEventPublisher;
import com.dancing_orangutan.ukkikki.event.travelPlanEvent.CompanionUpdatedEvent;
import com.dancing_orangutan.ukkikki.travelPlan.application.command.*;
import com.dancing_orangutan.ukkikki.travelPlan.application.query.FetchSuggestedTravelPlanQuery;
import com.dancing_orangutan.ukkikki.travelPlan.application.query.SearchTravelPlanQuery;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanRead;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.memberTravelPlan.MemberTravelPlanFinder;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.memberTravelPlan.MemberTravelPlanModifier;
import com.dancing_orangutan.ukkikki.travelPlan.ui.response.CreateTravelPlanResponse;
import com.dancing_orangutan.ukkikki.travelPlan.infrastructure.travelPlan.TravelPlanRepository;
import com.dancing_orangutan.ukkikki.travelPlan.ui.response.FetchSuggestedTravelPlanResponse;
import com.dancing_orangutan.ukkikki.travelPlan.ui.response.JoinTravelPlanResponse;
import com.dancing_orangutan.ukkikki.travelPlan.ui.response.SearchTravelPlanResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TravelPlanService {

	private final TravelPlanRepository travelPlanRepository;
	private final MemberTravelPlanFinder memberTravelPlanFinder;
	private final MemberTravelPlanModifier memberTravelPlanModifier;
	private final SpringEventPublisher springEventPublisher;

	@Transactional
	public CreateTravelPlanResponse createTravelPlan(CreateTravelPlanCommand command) {
		TravelPlan domain = command.commandToDomain();
		TravelPlan savedTravelPlan = travelPlanRepository.save(domain);
		return CreateTravelPlanResponse.toResponse(savedTravelPlan);
	}

	@Transactional
	public JoinTravelPlanResponse joinTravelPlan(JoinTravelPlanCommand command) {
		MemberTravelPlan memberTravelPlan = memberTravelPlanFinder.findMemberTravelPlan(command.memberId(), command.travelPlanId());


		TravelPlan domain = command.commandToDomain();

		if (memberTravelPlan.isJoining(command.memberId())) {
			memberTravelPlanModifier.modifyLastJoinTime(command.memberId(), command.travelPlanId());
		} else {
			travelPlanRepository.joinTravelPlan(domain);
		}

		List<TravelPlan> fetchedTravelPlans = travelPlanRepository.fetchTravelPlans(domain);

		//TODO
		// 여행 계획 ID와 관련된 모든 데이터 조회
		return JoinTravelPlanResponse.builder()
				.
	}

	public List<SearchTravelPlanResponse> searchTravelPlan(SearchTravelPlanQuery query) {
		TravelPlan domain = query.queryToDomain();
		List<TravelPlan> travelPlans = travelPlanRepository.searchTravelPlan(domain);
		return travelPlans.stream()
				.map(SearchTravelPlanResponse::domainToResponse)
				.toList();
	}

	public List<FetchSuggestedTravelPlanResponse> fetchSuggestedTravelPlans(FetchSuggestedTravelPlanQuery query) {
		TravelPlan domain = query.queryToDomain();
		List<TravelPlan> travelPlans = travelPlanRepository.fetchTravelPlans(domain);
		return travelPlans.stream()
				.map(FetchSuggestedTravelPlanResponse::domainToResponse)
				.toList();
	}

	@Transactional
	public void updateTravelPlanStatus(UpdateTravelPlanStatusCommand command) {
		TravelPlan domain = command.commandToDomain();
		travelPlanRepository.updateTravelPlanStatus(domain);
	}

	@Transactional
	public void writeComment(WriteCommentCommand command) {
		TravelPlan domain = command.commandToDomain();
		travelPlanRepository.writeComment(domain);
	}

	@Transactional
	public void updateCloseTime(UpdateCloseTimeCommand command) {
		TravelPlan domain = command.commandToDomain();
		TravelPlan result = travelPlanRepository.updateCloseTime(domain);
		result.validateCreatedAndCloseTime();
	}

	@Transactional
	public void updateHost(UpdateCompanionCommand command) {

		TravelPlan domain = command.commandToDomain();
		travelPlanRepository.updateCompanion(domain);

		domain.memberTravelPlans()
				.forEach(memberTravelPlan -> {
					CompanionUpdatedEvent event = CompanionUpdatedEvent.builder()
							.adultCount(memberTravelPlan.adultCount())
							.childCount(memberTravelPlan.childCount())
							.infantCount(memberTravelPlan.infantCount())
							.memberId(memberTravelPlan.memberId())
							.travelPlanId(domain.travelPlanInfo().travelPlanId())
							.build();
					springEventPublisher.publish(event);
				});
	}

	public void exitTravelPlan(ExitTravelPlanCommand command) {

		//만약 방장인데
		if (memberTravelPlanDomain.exitYn()) {
			ㄱ
		}


	}
}