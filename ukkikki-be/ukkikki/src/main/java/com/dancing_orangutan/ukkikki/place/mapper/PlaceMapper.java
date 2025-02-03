package com.dancing_orangutan.ukkikki.place.mapper;

import com.dancing_orangutan.ukkikki.place.domain.Place;
import com.dancing_orangutan.ukkikki.place.domain.PlaceEntity;

public class PlaceMapper {
    
    // TODO: TravelPlan 객체 필요
    public static PlaceEntity mapToEntity(Place place) {
        return PlaceEntity.builder()
                .placeId(place.getPlaceId())
                .name(place.getName())
                .address(place.getAddress())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .build();
    }
}
