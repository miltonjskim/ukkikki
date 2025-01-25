package domain.travelPlan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "places")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeId;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(nullable = false)
	private BigDecimal latitude;

	@Column(nullable = false)
	private BigDecimal longitude;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "travel_plan_id")
	private TravelPlan travelPlan;
}
