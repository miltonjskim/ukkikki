package com.dancing_orangutan.ukkikki.placeTag;

import com.dancing_orangutan.ukkikki.entity.travelPlan.MemberTravelPlan;
import com.dancing_orangutan.ukkikki.place.domain.PlaceEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place_tags")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceTagEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer placeTagId;

	@Column(nullable = false, name = "place_tag_name", length = 50)
	private String placeTagName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id")
	private PlaceEntity placeEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "travel_plan_id"),
			@JoinColumn(name = "member_id")
	})
	private MemberTravelPlan memberTravelPlan;
}
