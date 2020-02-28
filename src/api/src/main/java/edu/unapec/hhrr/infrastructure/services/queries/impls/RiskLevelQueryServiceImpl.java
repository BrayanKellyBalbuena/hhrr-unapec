package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.repositories.queries.RiskLevelQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.RiskLevelQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RiskLevelQueryServiceImpl extends EntityQueryServiceImpl<RiskLevel, Long> implements RiskLevelQueryService {

    private RiskLevelQueryRepository riskLevelQueryRepository;

    public RiskLevelQueryServiceImpl(@Autowired RiskLevelQueryRepository repository) {
        super(repository);
        this.riskLevelQueryRepository = repository;
    }

    @Override
    public Page<RiskLevel> findByName(String name, Pageable pageable) {
        return riskLevelQueryRepository.findByNameContains(name, pageable);
    }

    @Override
    public Page<RiskLevel> findByDescription(String description, Pageable pageable) {
        return riskLevelQueryRepository.findByDescriptionContains(description, pageable);
    }
}
