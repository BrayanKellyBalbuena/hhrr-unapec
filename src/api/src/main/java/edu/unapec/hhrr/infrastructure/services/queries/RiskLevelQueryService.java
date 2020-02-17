package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.core.entities.RiskLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RiskLevelQueryService extends EntityQueryService<RiskLevel, Long> {
    Page<RiskLevel> findByName(String name, Pageable pageable);
    Page<RiskLevel> findByDescription(String description, Pageable pageable);
}
