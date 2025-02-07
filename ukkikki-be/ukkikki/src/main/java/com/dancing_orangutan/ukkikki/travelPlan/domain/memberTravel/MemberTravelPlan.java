package com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel;

import lombok.Builder;

public record MemberTravelPlan(boolean hostYn,Integer memberId, int adultCount, int childCount, int infantCount) {

    @Builder
    public MemberTravelPlan{

    }

    public boolean isJoining(Integer memberId) {
        return memberId.equals(this.memberId);
    }
}
