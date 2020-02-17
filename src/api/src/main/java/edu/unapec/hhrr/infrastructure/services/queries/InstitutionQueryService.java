package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.core.entities.RiskLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstitutionQueryService extends EntityQueryService<Institution, Long> {
    Page<Institution> findByName(String name, Pageable pageable);
    Page<Institution> findByDescription(String description, Pageable pageable);
}
