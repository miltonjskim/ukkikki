package com.dancing_orangutan.ukkikki.place.mapper;

import com.dancing_orangutan.ukkikki.place.domain.place.PlaceEntity;
import com.dancing_orangutan.ukkikki.place.domain.placeTag.PlaceTag;
import com.dancing_orangutan.ukkikki.place.domain.placeTag.PlaceTagEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravelPlan.MemberTravelPlanEntity;

public class PlaceTagMapper {

    public static PlaceTagEntity mapToEntity(PlaceTag placeTag,
                                             PlaceEntity placeEntity,
                                             MemberTravelPlanEntity memberTravelPlanEntity) {
        return PlaceTagEntity.builder()
                .placeTagName(placeTag.getPlaceTagName())
                .placeEntity(placeEntity)
                .memberTravelPlan(memberTravelPlanEntity)
                .build();
    }

    public static PlaceTag mapToDomain(PlaceTagEntity placeTagEntity) {

        return PlaceTag.builder()
                .placeTagName(placeTagEntity.getPlaceTagName())
                .placeTagId(placeTagEntity.getPlaceTagId())
                .creatorId(placeTagEntity.getMemberTravelPlan().getMemberTravelPlanId().getMemberId())
                .placeId(placeTagEntity.getPlaceEntity().getPlaceId())
                .build();
    }
}
