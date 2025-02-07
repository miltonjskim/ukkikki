package com.dancing_orangutan.ukkikki.travelPlan.application.command;

import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import lombok.Builder;

public record WriteCommentCommand(String hostComment, Integer travelPlanId) {

	@Builder
	public WriteCommentCommand {
	}

	public void validate() {
		if (hostComment == null) {
			throw new IllegalArgumentException("댓글 내용은 반드시 입력해야 합니다.");
		}

		if (travelPlanId == null) {
			throw new IllegalArgumentException("여행 계획 ID는 필수 입력값입니다.");
		}
	}

	public TravelPlan commandToDomain() {
		return TravelPlan.builder()
				.travelPlanInfo(TravelPlanInfo.builder()
						.travelPlanId(travelPlanId)
						.hostComment(hostComment)
						.build())
				.build();
	}
}
