package com.dancing_orangutan.ukkikki.travelPlan.infrastructure.memberTravelPlan;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.mapper.MemberTravelPlanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberTravelPlanFinder {

    private final JpaMemberTravelPlanRepository repository;
    private final MemberTravelPlanMapper mapper;

    public boolean isJoiningTravelPlan(Integer memberId, Integer travelPlanId) {
        return repository.existsByMember_MemberIdAndTravelPlan_TravelPlanId(memberId, travelPlanId);
    }

    public MemberTravelPlan findMemberTravelPlan(Integer memberId, Integer travelPlanId) {
        return mapper.entityToDomain(repository.findMemberTravelPlanEntityByMember_MemberIdAndTravelPlan_TravelPlanId(memberId, travelPlanId));
    }
}
