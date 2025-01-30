package com.dancing_orangutan.ukkikki.place;

import com.dancing_orangutan.ukkikki.global.response.ApiUtils;
import com.dancing_orangutan.ukkikki.global.response.ApiUtils.ApiResponse;
import com.dancing_orangutan.ukkikki.place.dto.CreatePlaceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/travel-plans/{travelPlanId}")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceServiceImpl placeService;

    @PostMapping("/places")
    public ApiResponse<String> createPlace(@PathVariable Integer travelPlanId,
                                            @RequestBody CreatePlaceRequest createPlaceRequest) {


        return ApiUtils.success("여행 계획 장소를 등록하였습니다.");
    }
}
