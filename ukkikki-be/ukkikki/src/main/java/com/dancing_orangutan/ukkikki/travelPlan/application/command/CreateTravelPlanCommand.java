package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.travelPlan.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.Host;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

import java.time.LocalDate;

import java.util.List;

public record CreateTravelPlanCommand(
		Integer departureCityId,
		Integer arrivalCityId,
		String name,
		LocalDate startDate,
		LocalDate endDate,
		List<Integer> keywords,
		int minPeople,
		int maxPeople,
		int adultCount,
		int childCount,
		int infantCount,
		PlanningStatus planningStatus,
		Integer memberId
) {
	@Builder
	public CreateTravelPlanCommand{

	}

	public TravelPlan commandToDomain() {
		return TravelPlan.builder()
				.travelPlanInfo(TravelPlanInfo.builder()
						.name(name)
						.departureCityId(departureCityId)
						.arrivalCityId(arrivalCityId)
						.planningStatus(planningStatus)
						.startDate(startDate)
						.endDate(endDate)
						.minPeople(minPeople)
						.maxPeople(maxPeople)
						.keywords(keywords)
						.build())
				.host(Host.builder()
						.adultCount(adultCount)
						.infantCount(infantCount)
						.childCount(childCount)
						.memberId(memberId)
						.build())
				.build();
	}
}
