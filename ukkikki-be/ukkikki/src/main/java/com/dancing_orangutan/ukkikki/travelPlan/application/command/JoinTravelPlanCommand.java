package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

import java.util.List;


public record JoinTravelPlanCommand(
        int adultCount,
        int childCount,
        int infantCount,
        Integer travelPlanId,
        Integer memberId
) {

    @Builder
    public JoinTravelPlanCommand {
    }

    public TravelPlan commandToDomain() {
        return TravelPlan.builder()
                .travelPlanInfo(TravelPlanInfo.builder()
                        .travelPlanId(travelPlanId)
                        .build())
                .memberTravelPlans(List.of(MemberTravelPlan.builder()
                        .memberId(memberId)
                        .infantCount(infantCount)
                        .childCount(childCount)
                        .adultCount(adultCount)
                        .build()))
                .build();
    }
}

