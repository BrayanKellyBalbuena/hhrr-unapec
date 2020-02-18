package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.repositories.queries.JobQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.SkillQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.JobQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobQueryServiceImpl extends EntityQueryServiceImpl<Job, Long> implements JobQueryService {

    private JobQueryRepository queryRepository;

    public JobQueryServiceImpl(@Autowired JobQueryRepository repository) {
        super(repository);
        this.queryRepository = repository;
    }

    @Override
    public Page<Job> findByName(String name, Pageable pageable) {
        return queryRepository.findByNameContains(name, pageable);
    }

    @Override
    public Page<Job> findByDescription(String description, Pageable pageable) {
        return queryRepository.findByDescriptionContains(description, pageable);
    }
}
