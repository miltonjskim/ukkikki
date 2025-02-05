package com.dancing_orangutan.ukkikki.proposal.infrastructure.proposal;

import com.dancing_orangutan.ukkikki.entity.info.Airport;
import com.dancing_orangutan.ukkikki.member.domain.CompanyEntity;
import com.dancing_orangutan.ukkikki.proposal.domain.proposal.Proposal;
import com.dancing_orangutan.ukkikki.proposal.domain.proposal.ProposalEntity;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.airport.AirportFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.company.CompanyFinder;
import com.dancing_orangutan.ukkikki.proposal.infrastructure.travelPlan.TravelPlanFinder;
import com.dancing_orangutan.ukkikki.proposal.mapper.ProposalMapper;
import com.dancing_orangutan.ukkikki.travelPlan.domain.travelPlan.TravelPlanEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProposalRepository  {

    private final JpaProposalRepository jpaProposalRepository;
    private final ProposalMapper proposalMapper;
    private final AirportFinder airportFinder;
    private final CompanyFinder companyFinder;
    private final TravelPlanFinder travelPlanFinder;

    public Proposal save(final Proposal proposalDomain) {

        Airport departureAirport = airportFinder.getReferenceById(proposalDomain.getDepartureAirportCode());
        Airport arrivalAirport = airportFinder.getReferenceById(proposalDomain.getArrivalAirportCode());
        CompanyEntity company = companyFinder.getReferenceById(proposalDomain.getCompanyId());
        TravelPlanEntity travelPlan = travelPlanFinder.getReferenceById(proposalDomain.getTravelPlanId());

        ProposalEntity proposalEntity = ProposalEntity.builder()
                .startDate(proposalDomain.getStartDate())
                .endDate(proposalDomain.getEndDate())
                .airline(proposalDomain.getAirline())
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .startDateBoardingTime(proposalDomain.getStartDateBoardingTime())
                .endDateBoardingTime(proposalDomain.getEndDateBoardingTime())
                .startDateArrivalTime(proposalDomain.getStartDateArrivalTime())
                .endDateArrivalTime(proposalDomain.getEndDateArrivalTime())
                .deposit(proposalDomain.getDeposit())
                .minPeople(proposalDomain.getMinPeople())
                .guideIncluded(proposalDomain.isGuideIncluded())
                .productIntroduction(proposalDomain.getProductIntroduction())
                .refundPolicy(proposalDomain.getRefundPolicy())
                .insuranceIncluded(proposalDomain.isInsuranceIncluded())
                .proposalStatus(proposalDomain.getProposalStatus())
                .createTime(proposalDomain.getCreateTime())
                .updateTime(proposalDomain.getUpdateTime())
                .company(company)
                .travelPlan(travelPlan)
                .build();

        return proposalMapper.entityToDomain(jpaProposalRepository.save(proposalEntity));
    }

    public Proposal findById(Integer proposalId) {

        ProposalEntity entity = jpaProposalRepository.findById(proposalId)
                .orElseThrow(() -> new EntityNotFoundException("해당 제안서를 찾을 수 없습니다."));

        return proposalMapper.entityToDomain(entity);
    }

}
