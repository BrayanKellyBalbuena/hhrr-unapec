package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.repositories.queries.TrainingQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.TrainingQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrainingQueryServiceImpl extends EntityQueryServiceImpl<Training, Long> implements TrainingQueryService {

    private TrainingQueryRepository queryRepository;

    public TrainingQueryServiceImpl(@Autowired TrainingQueryRepository repository) {
        super(repository);
        this.queryRepository = repository;
    }

    @Override
    public Page<Training> findByName(String name, Pageable pageable) {
        this.queryRepository.findByDescriptionContains(name, pageable);
        return queryRepository.findByNameContains(name, pageable);
    }

    @Override
    public Page<Training> findByDescription(String description, Pageable pageable) {
        return queryRepository.findByDescriptionContains(description, pageable);
    }
}
