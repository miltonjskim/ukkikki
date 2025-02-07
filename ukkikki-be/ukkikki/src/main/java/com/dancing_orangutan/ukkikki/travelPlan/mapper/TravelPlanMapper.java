package com.dancing_orangutan.ukkikki.travelPlan.mapper;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanInfo;
import org.springframework.stereotype.Component;

@Component
public class TravelPlanMapper {

    public TravelPlan entityToDomain(TravelPlanEntity entity) {
        return TravelPlan.builder()
                .travelPlanInfo(mapToTravelPlanInfo(entity))
                .memberTravelPlans(entity.getMemberTravelPlans().stream()
                        .map(this::mapToMemberTravelPlan).toList())
                .build();
    }

    private TravelPlanInfo mapToTravelPlanInfo(TravelPlanEntity entity) {
        return TravelPlanInfo.builder()
                .travelPlanId(entity.getTravelPlanId())
                .name(entity.getName())
                .departureCityId(entity.getDepartureCity().getCityId())
                .arrivalCityId(entity.getArrivalCity().getCityId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .minPeople(entity.getMinPeople())
                .maxPeople(entity.getMaxPeople())
                .planningStatus(entity.getPlanningStatus())
                .hostComment(entity.getHostComment())
                .keywords(
                        entity.getTravelPlanKeywords().stream()
                                .map(keywordEntity -> keywordEntity.getKeyword().getKeywordId())
                                .toList()
                )
                .createTime(entity.getCreateTime())
                .closeTime(entity.getCloseTime())
                .build();
    }

    private MemberTravelPlan mapToMemberTravelPlan(MemberTravelPlanEntity entity) {
        return MemberTravelPlan.builder()
                .hostYn(entity.isHostYn())
                .adultCount(entity.getAdultCount())
                .childCount(entity.getChildCount())
                .infantCount(entity.getInfantCount())
                .build();
    }
}
