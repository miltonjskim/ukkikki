package com.dancing_orangutan.ukkikki.travelPlan.ui.response;

import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.ui.KeywordUi;
import com.dancing_orangutan.ukkikki.travelPlan.ui.TravelPlanInfoUi;


import java.util.List;
import java.util.stream.Collectors;

public record CreateTravelPlanResponse(TravelPlanInfoUi travelPlan) {

	public static CreateTravelPlanResponse toResponse(TravelPlan travelPlan) {
		if (travelPlan == null) {
			return null;
		}
		TravelPlanInfoUi travelPlanInfoUi = new TravelPlanInfoUi(
				travelPlan.travelPlanInfo().name(),
				travelPlan.travelPlanInfo().departureCityId(),
				travelPlan.travelPlanInfo().arrivalCityId(),
				travelPlan.travelPlanInfo().startDate(),
				travelPlan.travelPlanInfo().endDate(),
				travelPlan.travelPlanInfo().minPeople(),
				travelPlan.travelPlanInfo().maxPeople(),
				travelPlan.travelPlanInfo().planningStatus(),
				mapKeywords(travelPlan.travelPlanInfo().keywords())
		);

		return new CreateTravelPlanResponse(travelPlanInfoUi);
	}

	private static List<KeywordUi> mapKeywords(List<Integer> keywordIds) {
		if (keywordIds == null) {
			return null;
		}
		return keywordIds.stream().map(KeywordUi::new).collect(Collectors.toList());
	}
}
