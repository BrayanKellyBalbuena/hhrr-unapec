package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SkillQueryService extends EntityQueryService<Skill, Long> {
    Page<Skill> findByName(String name, Pageable pageable);
    Page<Skill> findByDescription(String description, Pageable pageable);
}
