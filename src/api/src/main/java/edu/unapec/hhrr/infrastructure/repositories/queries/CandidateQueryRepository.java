package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.core.entities.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CandidateQueryRepository extends EntityQueryRepository<Candidate, Long> {
    Page<Candidate> findByFirstNameContains(String name, Pageable pageable);
    Page<Candidate> findByLastNameContains(String lastName, Pageable pageable);
    Page<Candidate> findByIdentityCardContains(String identityCard, Pageable pageable);
    Page<Candidate> findByAgeEquals(short age, Pageable pageable);
    Page<Candidate> findAllBySkillsEquals (Long skill, Pageable pageable);
    Optional<Candidate> findByUserId(Long userId);
}
