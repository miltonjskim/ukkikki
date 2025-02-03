package com.dancing_orangutan.ukkikki.place.ui.response;

import com.dancing_orangutan.ukkikki.place.domain.PlaceTagEntity;

import java.util.List;

public class ListPlaceTagResponse {

    private final List<PlaceTagEntity> tags;

    public ListPlaceTagResponse(List<PlaceTagEntity> tags) {
        this.tags = tags;
    }
}
