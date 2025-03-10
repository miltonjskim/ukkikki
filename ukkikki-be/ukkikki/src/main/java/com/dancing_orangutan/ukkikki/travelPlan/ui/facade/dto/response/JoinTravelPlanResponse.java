package com.dancing_orangutan.ukkikki.travelPlan.ui.facade.dto.response;

import com.dancing_orangutan.ukkikki.geography.domain.city.CityEntity;
import com.dancing_orangutan.ukkikki.place.domain.place.PlaceEntity;
import com.dancing_orangutan.ukkikki.place.domain.placeTag.PlaceTagEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.constant.PlanningStatus;
import com.dancing_orangutan.ukkikki.travelPlan.domain.keyword.KeywordEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravelPlan.MemberTravelPlanEntity;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanEntity;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record JoinTravelPlanResponse(List<MemberResponse> members, TravelPlanResponse travelPlan) {

	public static JoinTravelPlanResponse fromEntity(final TravelPlanEntity travelPlanEntity, final Integer memberId) {
		return JoinTravelPlanResponse.builder()
				.members(travelPlanEntity.getMemberTravelPlans().stream()
						.map(MemberResponse::fromEntity)
						.toList())
				.travelPlan(TravelPlanResponse.fromEntity(travelPlanEntity,memberId))
				.build();
	}

	@Builder
	public JoinTravelPlanResponse {}

	// 🔒 내부 `record`: 여행 플랜 상세 정보
	@Builder
	private record TravelPlanResponse(
			Integer travelPlanId,
			String name,
			CityResponse arrivalCity,
			CityResponse departureCity,
			LocalDate startDate,
			LocalDate endDate,
			PlanningStatus planningStatus,
			int minPeople,
			int maxPeople,
			int currentParticipants,
			List<KeywordResponse> keywords,
			List<PlaceResponse> places,
			LocalDateTime closeTime
	) {
		private static TravelPlanResponse fromEntity(TravelPlanEntity entity, Integer memberId) {
			return TravelPlanResponse.builder()
					.travelPlanId(entity.getTravelPlanId())
					.name(entity.getName())
					.arrivalCity(CityResponse.fromEntity(entity.getArrivalCity()))
					.departureCity(CityResponse.fromEntity(entity.getDepartureCity()))
					.startDate(entity.getStartDate())
					.endDate(entity.getEndDate())
					.planningStatus(entity.getPlanningStatus())
					.minPeople(entity.getMinPeople())
					.maxPeople(entity.getMaxPeople())
					.currentParticipants(entity.calCurrentParticipants())
					.keywords(entity.getTravelPlanKeywords().stream()
							.map(travelPlanKeywordEntity -> KeywordResponse.fromEntity(travelPlanKeywordEntity.getKeyword()))
							.collect(Collectors.toList()))
					.closeTime(entity.getCloseTime())
					.places(entity.getPlaces().stream()
							.map(placeEntity-> PlaceResponse.fromEntity(placeEntity,memberId))
							.toList())
					.build();
		}
	}

	/**
	 *
	 * @param cityId
	 * @param name
	 */
	@Builder
	private record CityResponse(
			Integer cityId,
			String name
	) {
		private static CityResponse fromEntity(CityEntity entity) {
			return CityResponse.builder()
					.cityId(entity.getCityId())
					.name(entity.getName())
					.build();
		}
	}

	/**
	 *
	 * @param keywordId
	 * @param name
	 */
	@Builder
	private record KeywordResponse(
			Integer keywordId,
			String name
	) {
		private static KeywordResponse fromEntity(KeywordEntity entity) {
			return KeywordResponse.builder()
					.keywordId(entity.getKeywordId())
					.name(entity.getName())
					.build();
		}
	}

	/**
	 *
	 * @param name
	 * @param hostYn
	 * @param totalPeopleCount
	 */
	@Builder
	private record MemberResponse(
			String name,
			boolean hostYn,
			int totalPeopleCount
	) {
		private static MemberResponse fromEntity(MemberTravelPlanEntity entity) {
			return MemberResponse.builder()
					.name(entity.getMember().getName())
					.totalPeopleCount(entity.calTotalParticipants())
					.hostYn(entity.isHostYn())
					.build();
		}
	}

	@Builder
	public record PlaceResponse(
			Integer placeId,
			String name,
			Integer likeCount,
			double latitude,
			double longitude,
			List<PlaceTagResponse> tags,
			boolean likeYn
	) {

		private static PlaceResponse fromEntity(PlaceEntity entity, Integer memberId) {
			return PlaceResponse.builder()
					.placeId(entity.getPlaceId())
					.name(entity.getName())
					.likeCount(entity.countLikes())
					.latitude(entity.getLatitude())
					.longitude(entity.getLongitude())
					.tags(entity.getPlaceTags().stream()
							.map(placeTagEntity-> PlaceTagResponse.fromEntity(placeTagEntity,memberId))
							.toList())
					.likeYn(entity.isLiked(memberId))
					.build();
		}

	}


	@Builder
	private record PlaceTagResponse(Integer placeTagId,
								   String name,

								   boolean isMyTag) {

		private static PlaceTagResponse fromEntity(PlaceTagEntity entity,Integer memberId) {
			return PlaceTagResponse.builder()
					.name(entity.getPlaceTagName())
					.placeTagId(entity.getPlaceTagId())
					.isMyTag(entity.isMyTag(memberId))
					.build();
		}

	}
}
