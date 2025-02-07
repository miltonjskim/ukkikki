package com.dancing_orangutan.ukkikki.travelPlan.application.query;

import com.dancing_orangutan.ukkikki.travelPlan.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

public record FetchSuggestedTravelPlanQuery(PlanningStatus status) {

    @Builder
    public FetchSuggestedTravelPlanQuery {

    }

    public TravelPlan queryToDomain() {
        return TravelPlan.builder()
                .travelPlanInfo(
                        TravelPlanInfo.builder()
                                .planningStatus(status)
                                .build())
                .build();

    }
}
