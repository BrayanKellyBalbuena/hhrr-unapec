package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.repositories.queries.InstitutionQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.RiskLevelQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.InstitutionQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.RiskLevelQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InstitutionQueryServiceImpl extends EntityQueryServiceImpl<Institution, Long> implements InstitutionQueryService {

    private InstitutionQueryRepository queryRepository;

    public InstitutionQueryServiceImpl(@Autowired InstitutionQueryRepository repository) {
        super(repository);
        this.queryRepository = repository;
    }

    @Override
    public Page<Institution> findByName(String name, Pageable pageable) {
        return queryRepository.findByNameContains(name, pageable);
    }

    @Override
    public Page<Institution> findByDescription(String description, Pageable pageable) {
        return queryRepository.findByDescriptionContains(description, pageable);
    }
}
