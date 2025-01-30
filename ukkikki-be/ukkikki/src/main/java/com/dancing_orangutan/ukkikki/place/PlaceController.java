package com.dancing_orangutan.ukkikki.place;

import com.dancing_orangutan.ukkikki.global.response.ApiUtils;
import com.dancing_orangutan.ukkikki.global.response.ApiUtils.ApiResponse;
import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceCommand;
import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/api/v1/travel-plans/{travelPlanId}"))
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/places")
    public ApiResponse<String> createPlace(@PathVariable Integer travelPlanId,
                                            @RequestBody CreatePlaceRequest createPlaceRequest) {

        CreatePlaceCommand command = CreatePlaceCommand.builder()
                .travelPlanId(travelPlanId)
                .name(createPlaceRequest.getName())
                .address(createPlaceRequest.getAddress())
                .latitude(createPlaceRequest.getLatitude())
                .longitude(createPlaceRequest.getLongitude())
                .build();

        placeService.save(command);

        return ApiUtils.success("여행 계획 장소를 등록하였습니다.");
    }
}
