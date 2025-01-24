package domain.travelPlan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserTravelPlanId implements Serializable {

	@Column
	@EqualsAndHashCode.Include
	private Long travelPlanId;

	@EqualsAndHashCode.Include
	@Column
	private Long memberId;

}
