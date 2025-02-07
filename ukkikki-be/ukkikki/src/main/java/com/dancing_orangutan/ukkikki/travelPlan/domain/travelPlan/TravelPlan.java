package com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan;


import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public record TravelPlan(TravelPlanInfo travelPlanInfo, List<MemberTravelPlan> memberTravelPlans) {

	@Builder()
	public TravelPlan {
	}

	public void validateCreatedAndCloseTime() {
		if (travelPlanInfo.createTime().isBefore(travelPlanInfo.closeTime())) {
			throw new IllegalArgumentException("마감 일시는 생성 일시보다 이전일 수 없습니다.");
		}
	}

	public int calCurPeopleCount() {
		return memberTravelPlans.stream()
				.mapToInt(memberTravelPlan -> memberTravelPlan.adultCount() + memberTravelPlan.childCount() + memberTravelPlan.infantCount())
				.sum();
	}
}

