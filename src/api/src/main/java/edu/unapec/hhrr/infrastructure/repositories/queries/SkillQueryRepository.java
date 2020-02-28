package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface SkillQueryRepository extends EntityQueryRepository<Skill, Long> {
    Page<Skill> findByNameContains(String name, Pageable pageable);
    Page<Skill> findByDescriptionContains(String name, Pageable pageable);
    @Query(
            value = "select s.* from skills s join candidates_skills c on s.id=c.skill_id and c.candidate_id=?1 ORDER BY s.id",
            countQuery = "SELECT count(*) from skills s join candidates_skills c on s.id=c.skill_id and c.candidate_id=?1",
            nativeQuery = true)
    Page<Skill> findByCandidateId(long userId, Pageable pageable);

    @Query(
            value = "select s.* from skills s where not exists (select skill_id from candidates_skills c where skill_id = s.id and c.candidate_id=?1)",
            countQuery = "SELECT count(*) from skills s where not exists (select skill_id from candidates_skills where skill_id = s.id and c.candidate_id=?1)",
            nativeQuery = true)
    Page<Skill> findAllNotMatchCandidate(long userId,Pageable pageable);
}
