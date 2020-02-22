package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CandidateQueryService  extends  EntityQueryService<Candidate, Long> {
    Page<Candidate> findByFirstNameContains(String name, Pageable pageable);
    Page<Candidate> findByLastNameContains(String lastName, Pageable pageable);
    Page<Candidate> findByIdentityCardContains(String identityCard, Pageable pageable);
    Page<Candidate> findByAgeEquals(short age, Pageable pageable);
    Page<Candidate> findAllBySkillsEquals (Long skill, Pageable pageable);
}
