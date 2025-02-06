package com.dancing_orangutan.ukkikki.place.mapper;

import com.dancing_orangutan.ukkikki.place.domain.place.Place;
import com.dancing_orangutan.ukkikki.place.domain.place.PlaceEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanEntity;

public class PlaceMapper {
    
    public static PlaceEntity mapToEntity(Place place, TravelPlanEntity travelPlan) {
        return PlaceEntity.builder()
                .name(place.getName())
                .address(place.getAddress())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .travelPlan(travelPlan)
                .build();
    }
}
