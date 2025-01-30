package com.dancing_orangutan.ukkikki.place;

import com.dancing_orangutan.ukkikki.entity.travelPlan.TravelPlan;
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
public class PlaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer placeId;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(nullable = false)
	private double latitude;

	@Column(nullable = false)
	private double longitude;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "travel_plan_id")
	private TravelPlan travelPlan;
}
