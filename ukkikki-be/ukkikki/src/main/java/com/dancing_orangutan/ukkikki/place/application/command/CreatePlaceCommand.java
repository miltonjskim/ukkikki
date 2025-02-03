package com.dancing_orangutan.ukkikki.place.application.command;

import lombok.Builder;

@Builder
public class CreatePlaceCommand {

    private Integer travelPlanId;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
