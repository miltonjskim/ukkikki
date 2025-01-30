package com.dancing_orangutan.ukkikki.place;

import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceCommand;
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
