package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobQueryRepository extends EntityQueryRepository<Job, Long> {
    Page<Job> findByNameContains(String name, Pageable pageable);
    Page<Job> findByDescriptionContains(String description, Pageable pageable);
    @Query(
            value = "SELECT j.* FROM jobs j JOIN jobs_candidates jc on j.id=jc.job_id and jc.candidate_id=?1 ORDER BY j.id",
            countQuery = "SELECT count(*) FROM jobs j JOIN jobs_candidates jc on j.id=jc.job_id and jc.candidate_id=?1",
            nativeQuery = true)
    Page<Job> findByCandidateId(long userId, Pageable pageable);

    @Query(
            value = "select j.* from jobs j where not exists (select job_id from jobs_candidates jc where job_id = j.id and jc.candidate_id=?1)",
            countQuery = "SELECT count(*) from jobs j where not exists (select job_id from jobs_candidates jc where job_id = j.id and jc.candidate_id=?1)",
            nativeQuery = true)
    Page<Job> findAllNotMatchCandidate(long userId,Pageable pageable);
}
