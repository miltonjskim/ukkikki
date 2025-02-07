package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.global.error.ApiException;
import com.dancing_orangutan.ukkikki.global.error.ErrorCode;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.Host;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

public record ExitTravelPlanCommand(Integer travelPlanId, Integer memberId) {


    @Builder
    public ExitTravelPlanCommand{

    }

    public TravelPlan commandToDomain() {
        return TravelPlan.builder()
                .travelPlanInfo(TravelPlanInfo.builder()
                        .travelPlanId(travelPlanId)
                        .build())
                .host(Host.builder()
                        .memberId(memberId)
                        .build())
                .build();
    }

    public void validate() {
        validateTravelPlanId();
        validateMemberId();
    }

    private void validateTravelPlanId() {
        if (travelPlanId == null || travelPlanId <= 0) {
            throw new ApiException(ErrorCode.TRAVEL_PLAN_ID_INVALID);
        }
    }

    private void validateMemberId() {
        if (memberId == null || memberId <= 0) {
            throw new ApiException(ErrorCode.MEMBER_ID_INVALID);
        }
    }
}
