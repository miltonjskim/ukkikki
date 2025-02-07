package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

import java.util.List;

public record UpdateCompanionCommand(Integer travelPlanId, Integer memberId, int adultCount, int childCount, int infantCount) {

    @Builder
    public UpdateCompanionCommand {

    }

    public void validate() {
        if(travelPlanId == null || travelPlanId <= 0) {
            throw new IllegalArgumentException("여행 계획 ID는 필수이며 양수입니다.");
        }

        if(adultCount<0 || infantCount<0 || childCount<0)  {
            throw new IllegalArgumentException("인원은 무조건 양수입니다.");
        }

        if (adultCount + infantCount + childCount < 1) {
            throw new IllegalArgumentException("인원은 한명이상 참여해야합니다.");
        }
    }

    public TravelPlan commandToDomain() {
        return TravelPlan.builder()
                .travelPlanInfo(TravelPlanInfo.builder()
                        .travelPlanId(travelPlanId)
                        .build())
                .memberTravelPlans(List.of(MemberTravelPlan.builder()
                                .memberId(memberId)
                                .adultCount(adultCount)
                                .childCount(childCount)
                                .infantCount(infantCount)
                        .build()))
                .build();
    }
}
