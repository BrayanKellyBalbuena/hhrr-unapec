package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.core.entities.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateQueryRepository extends EntityQueryRepository<Candidate, Long> {
    Page<Candidate> findByFirstNameContains(String name, Pageable pageable);
    Page<Candidate> findByLastNameContains(String lastName, Pageable pageable);
    Page<Candidate> findByIdentityCardContains(String identityCard, Pageable pageable);
    Page<Candidate> findByAgeEquals(short age, Pageable pageable);
    Page<Candidate> findAllBySkillsEquals (Long skill, Pageable pageable);
    Optional<Candidate> findByUserId(Long userId);
    @Query(
            value = "SELECT  c.* FROM candidates c INNER JOIN jobs_candidates jc ON c.id = jc.candidate_id AND jc.job_id =?1",
            countQuery = "SELECT COUNT(*) FROM candidates c INNER JOIN jobs_candidates jc ON c.id = jc.candidate_id AND jc.job_id =?1",
            nativeQuery = true
    )
    Page<Candidate> findAllCandidatesByApplyJobId(Long jobId, Pageable pageable);
}
