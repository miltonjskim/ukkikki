package com.dancing_orangutan.ukkikki.travelPlan.ui.response;

import com.dancing_orangutan.ukkikki.travelPlan.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.ui.KeywordUi;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public record SearchTravelPlanResponse(Integer travelPlanId,
                                       String name,
                                       Integer departureCityId,
                                       Integer arrivalCityId,
                                       LocalDate startDate,
                                       LocalDate endDate,
                                       int curPeople,
                                       int minPeople,
                                       int maxPeople,
                                       PlanningStatus planningStatus,
                                       List<KeywordUi> keywords) {

    @Builder
    public SearchTravelPlanResponse{

    }

    public static SearchTravelPlanResponse domainToResponse(TravelPlan travelPlan) {
        return SearchTravelPlanResponse.builder()
                .travelPlanId(travelPlan.travelPlanInfo().travelPlanId())
                .name(travelPlan.travelPlanInfo().name())
                .departureCityId(travelPlan.travelPlanInfo().departureCityId())
                .arrivalCityId(travelPlan.travelPlanInfo().arrivalCityId())
                .startDate(travelPlan.travelPlanInfo().startDate())
                .endDate(travelPlan.travelPlanInfo().endDate())
                .curPeople(travelPlan.calCurPeopleCount())
                .minPeople(travelPlan.travelPlanInfo().minPeople())
                .maxPeople(travelPlan.travelPlanInfo().maxPeople())
                .planningStatus(travelPlan.travelPlanInfo().planningStatus())
                .keywords(travelPlan.travelPlanInfo().keywords().stream()
                        .map(KeywordUi::new)
                        .collect(toList()))
                .build();
    }
}
