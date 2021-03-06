package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CandidateQueryService  extends  EntityQueryService<Candidate, Long> {
    Page<Candidate> findByFirstNameContains(String name, Pageable pageable);
    Page<Candidate> findByLastNameContains(String lastName, Pageable pageable);
    Page<Candidate> findByIdentityCardContains(String identityCard, Pageable pageable);
    Page<Candidate> findByAgeEquals(short age, Pageable pageable);
    Page<Candidate> findAllBySkillsEquals (Long skill, Pageable pageable);
    Optional<Candidate> findByUserId(Long id);
    Candidate getCurrentCandidate();
    Page<Candidate> findAllCandidatesByApplyJobId(Long jobId, PageRequestDto pageable);

}
