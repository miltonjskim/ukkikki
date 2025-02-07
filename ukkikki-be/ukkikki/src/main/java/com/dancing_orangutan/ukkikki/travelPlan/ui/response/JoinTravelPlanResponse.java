package com.dancing_orangutan.ukkikki.travelPlan.ui.response;

import java.util.List;



public record JoinTravelPlanResponse(List<MemberResponse> users, TravelPlanInfoResponse travelPlan,List<MessageInfoResponse> messages) {

}
