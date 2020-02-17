package edu.unapec.hhrr.infrastructure.repositories.queries;


import edu.unapec.hhrr.core.entities.RiskLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RiskLevelQueryRepository extends EntityQueryRepository<RiskLevel, Long> {
    Page<RiskLevel> findByNameContains(String name, Pageable pageable);
    Page<RiskLevel> findByDescriptionContains(String name, Pageable pageable);
}
