package com.dancing_orangutan.ukkikki.place.application.command;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DeletePlaceLikeCommand {

    private final Integer placeId;
    private final Integer memberId;
    private final Integer travelPlanId;

    @Builder
    public DeletePlaceLikeCommand(Integer placeId, Integer memberId,
                                  Integer travelPlanId) {
        this.placeId = placeId;
        this.memberId = memberId;
        this.travelPlanId = travelPlanId;
    }
}
