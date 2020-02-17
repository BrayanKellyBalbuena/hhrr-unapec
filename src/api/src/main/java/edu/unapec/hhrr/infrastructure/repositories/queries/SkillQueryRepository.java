package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillQueryRepository extends EntityQueryRepository<Skill, Long> {
    Page<Skill> findByNameContains(String name, Pageable pageable);
    Page<Skill> findByDescriptionContains(String name, Pageable pageable);
}
