package com.dancing_orangutan.ukkikki.place.application;

import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceCommand;
import com.dancing_orangutan.ukkikki.place.infrastructure.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;

    @Override
    public void save(CreatePlaceCommand command) {


    }
}
