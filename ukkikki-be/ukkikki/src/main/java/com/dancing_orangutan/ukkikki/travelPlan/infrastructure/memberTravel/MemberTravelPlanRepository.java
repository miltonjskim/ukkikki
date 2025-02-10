package com.dancing_orangutan.ukkikki.travelPlan.infrastructure.memberTravel;

import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanId;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTravelPlanRepository extends JpaRepository<MemberTravelPlanEntity, MemberTravelPlanId> {

	Optional<MemberTravelPlanEntity> findByMember_MemberIdAndTravelPlan_TravelPlanId(Integer memberId, Integer travelPlanId);

}
