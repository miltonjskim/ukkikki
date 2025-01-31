package com.dancing_orangutan.ukkikki.entity.proposal;

import com.dancing_orangutan.ukkikki.entity.travelPlan.MemberTravelPlan;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "inquiries")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Inquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inquiryId;

	@Column(nullable = false, length = 1000)
	private String title;

	@Column(nullable = false, length = 1000)
	private String content;

	@Column(nullable = false, length = 1000)
	private String answer;

	@CreatedDate
	@Column(nullable = false, name = "create_time")
	private LocalDateTime createTIme;

	@Column(name = "completed_time")
	private LocalDateTime completedTIme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proposal_id")
	private Proposal proposal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "travel_plan_id"),
			@JoinColumn(name = "member_id")
	})
	private MemberTravelPlan memberTravelPlan;
}
