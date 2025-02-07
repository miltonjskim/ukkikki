package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.travelPlan.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

public record UpdateTravelPlanStatusCommand(PlanningStatus planningStatus, Integer travelPlanId) {

    @Builder
    public UpdateTravelPlanStatusCommand {

    }

    public void validate() {
        if (planningStatus == null) {
            throw new IllegalArgumentException("여행 계획 상태는 필수입니다.");
        }
        if (travelPlanId == null) {
            throw new IllegalArgumentException("여행 계획 ID는 필수입니다.");
        }
    }

    public TravelPlan commandToDomain() {
        return TravelPlan.builder()
                .travelPlanInfo(TravelPlanInfo.builder()
                        .travelPlanId(travelPlanId)
                        .planningStatus(planningStatus)
                        .build())
                .build();
    }
}
