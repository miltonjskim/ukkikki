package com.dancing_orangutan.ukkikki.travelPlan.mapper;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import org.springframework.stereotype.Component;

@Component
public class MemberTravelPlanMapper {

    public MemberTravelPlan entityToDomain(MemberTravelPlanEntity entity) {
        return MemberTravelPlan.builder()
                .infantCount(entity.getInfantCount())
                .adultCount(entity.getAdultCount())
                .childCount(entity.getChildCount())
                .hostYn(entity.isHostYn())
                .build();
    }
}
