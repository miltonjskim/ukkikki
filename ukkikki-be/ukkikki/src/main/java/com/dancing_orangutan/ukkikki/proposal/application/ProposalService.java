package com.dancing_orangutan.ukkikki.proposal.application;

import com.dancing_orangutan.ukkikki.proposal.application.command.CreateInquiryCommand;
import com.dancing_orangutan.ukkikki.proposal.application.command.CreateProposalCommand;
import com.dancing_orangutan.ukkikki.proposal.application.command.CreateScheduleCommand;
import com.dancing_orangutan.ukkikki.proposal.domain.Inquiry.Inquiry;
import com.dancing_orangutan.ukkikki.proposal.domain.Inquiry.InquiryEntity;
import com.dancing_orangutan.ukkikki.proposal.domain.proposal.Proposal;
import com.dancing_orangutan.ukkikki.proposal.domain.proposal.ProposalEntity;
import com.dancing_orangutan.ukkikki.proposal.domain.schedule.Schedule;
import com.dancing_orangutan.ukkikki.proposal.domain.schedule.ScheduleEntity;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.inquiry.InquiryFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.inquiry.InquiryRepository;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.memberTravelPlan.MemberTravelPlanFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.proposal.ProposalFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.proposal.ProposalRepository;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.schedule.ScheduleFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.schedule.ScheduleRepository;
import com.dancing_orangutan.ukkikki.proposal.mapper.ScheduleMapper;
import com.dancing_orangutan.ukkikki.proposal.ui.response.*;
import com.dancing_orangutan.ukkikki.travelPlan.domain.memberTravel.MemberTravelPlanEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final ScheduleFinder scheduleFinder;
    private final MemberTravelPlanFinder memberTravelPlanFinder;
    private final ProposalFinder proposalFinder;
    private final InquiryRepository inquiryRepository;
    private final InquiryFinder inquiryFinder;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    // 제안서 작성
   public Proposal createProposal(CreateProposalCommand command){

       Proposal domain= Proposal.builder()
               .startDate(command.getStartDate())
               .endDate(command.getEndDate())
               .airline(command.getAirline())
               .departureAirportCode(command.getDepartureAirportCode())
               .arrivalAirportCode(command.getArrivalAirportCode())
               .startDateBoardingTime(command.getStartDateBoardingTime())
               .endDateBoardingTime(command.getEndDateBoardingTime())
               .startDateArrivalTime(command.getStartDateArrivalTime())
               .endDateArrivalTime(command.getEndDateArrivalTime())
               .deposit(command.getDeposit())
               .minPeople(command.getMinPeople())
               .guideIncluded(command.isGuideIncluded())
               .productIntroduction(command.getProductIntroduction())
               .refundPolicy(command.getRefundPolicy())
               .insuranceIncluded(command.isInsuranceIncluded())
               .proposalStatus(command.getProposalStatus())
               .createTime(LocalDateTime.now())
               .updateTime(LocalDateTime.now())
               .companyId(command.getCompanyId())
               .travelPlanId(command.getTravelPlanId())
               .build();

       return proposalRepository.save(domain);
   }

   // 제안서 상세 조회
    public ProposalDetailResponse getProposalDetail(Integer proposalId) {

        Proposal proposal = proposalRepository.findById(proposalId);

        List<ScheduleResponse> schedules = scheduleFinder.findSchedulesByProposalId(proposalId).stream()
                .map(schedule -> new ScheduleResponse(
                        schedule.getScheduleName(),
                        schedule.getStartTime(),
                        schedule.getEndTime(),
                        schedule.getImageUrl()))
                .collect(Collectors.toList());

        return new ProposalDetailResponse(proposal,schedules);
    }

    //제안서 문의
    public CreateInquiryResponse createInquiry(CreateInquiryCommand command) {

       // 사용자가 여행 계획에 참가하고 있는지 확인
        boolean isJoining = memberTravelPlanFinder.isJoiningTravelPlan(
                command.getMemberId(), command.getTravelPlanId());

        if (!isJoining) {
            throw new IllegalArgumentException("회원이 여행 계획에 속하지 않습니다.");
        }

        MemberTravelPlanEntity memberTravelPlan = memberTravelPlanFinder
                .findByTravelPlanIdAndMemberId(command.getTravelPlanId(), command.getMemberId());

        // ProposalEntity 조회
        Proposal proposal = proposalFinder.getProposalDomain(command.getProposalId());

        if (proposal == null) {
            throw new IllegalArgumentException("제안서를 찾을 수 없습니다.");
        }

        Inquiry inquiry = Inquiry.builder()
                .title(command.getTitle())
                .content(command.getContent())
                .createTIme(LocalDateTime.now())
                .proposalId(proposal.getProposalId())
                .memberId(memberTravelPlan.getMember().getMemberId())
                .travelPlanId(memberTravelPlan.getTravelPlan().getTravelPlanId())
                .build();

        Inquiry savedInquiry = inquiryRepository.save(inquiry);

        return CreateInquiryResponse.from(savedInquiry);
    }

    // 제안서 문의 목록 조회
    public List<InquiryListResponse> getInquiryList(Integer proposalId) {

        // Proposal 존재 여부 확인
        if (proposalRepository.findById(proposalId)==null) {
            throw new IllegalArgumentException("해당 proposalId에 대한 제안서를 찾을 수 없습니다: " + proposalId);
        }

        // InquiryFinder를 사용하여 문의 조회
        List<InquiryEntity> inquiries = inquiryFinder.findByProposalId(proposalId);

        // InquiryEntity → InquiryResponse 변환 후 반환
        return inquiries.stream()
                .map(InquiryListResponse::from)
                .collect(Collectors.toList());
    }

    //여행사 본인 제안서 목록 조회
    public List<CompanyProposalListResponse> getCompanyProposalList(Integer companyId) {

        List<CompanyProposalListResponse> proposals = proposalRepository.findByCompanyId(companyId).stream()
                .map(proposal -> CompanyProposalListResponse.builder()
                        .proposalId(proposal.getProposalId())
                        .travelPlanId(proposal.getTravelPlan().getTravelPlanId())
                        .startDate(proposal.getStartDate())
                        .endDate(proposal.getEndDate())
                        .airline(proposal.getAirline())
                        .departureAirportName(proposal.getDepartureAirport().getAirportName())
                        .arrivalAirportName(proposal.getArrivalAirport().getAirportName())
                        .deposit(proposal.getDeposit())
                        .minPeople(proposal.getMinPeople())
                        .proposalStatus(proposal.getProposalStatus().name())
                        .createTime(proposal.getCreateTime())
                        .build())
                .collect(Collectors.toList());

        return proposals;
    }

    //여행사 본인 제안서 상세 조회
    public CompanyProposalDetailResponse getCompanyProposalDetail(Integer proposalId,Integer companyId) {

        Proposal proposal = proposalRepository.findByProposalIdAndCompany_CompanyId(proposalId, companyId);

        List<ScheduleResponse> schedules = scheduleFinder.findSchedulesByProposalId(proposal.getProposalId()).stream()
                .map(schedule -> new ScheduleResponse(
                        schedule.getScheduleName(),
                        schedule.getStartTime(),
                        schedule.getEndTime(),
                        schedule.getImageUrl()))
                .collect(Collectors.toList());

        return new CompanyProposalDetailResponse(proposal, schedules);
    }

    // 제안서 내 일정 등록
    public Schedule createSchedule(CreateScheduleCommand command) {

       // 일정 등록 전 겹치는 일정이 있는지 확인
        Proposal proposal = proposalRepository.findById(command.getProposalId());

        List<Schedule> existingSchedules = scheduleFinder.findSchedulesByProposalId(proposal.getProposalId()).stream()
                .map(scheduleMapper::entityToDomain)
                .collect(Collectors.toList());

        // 새로운 Schedule 도메인 객체 생성
        if (Schedule.hasOverlappingSchedules(existingSchedules,command.getStartDate(), command.getEndDate())) {
            throw new IllegalArgumentException("새로운 일정이 기존 일정과 겹칩니다.");
        }

        // 새 일정 추가 후 저장
        Schedule schedule = Schedule.builder()
                .scheduleName(command.getScheduleName())
                .startTime(command.getStartDate())
                .endTime(command.getEndDate())
                .imageUrl(command.getImageUrl())
                .proposalId(command.getProposalId())
                .build();

        return scheduleRepository.save(schedule);
    }
}
