package com.dancing_orangutan.ukkikki.place.application;

import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceCommand;

public interface PlaceService {

    void save(CreatePlaceCommand command);
}
