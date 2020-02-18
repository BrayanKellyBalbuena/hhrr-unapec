package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.infrastructure.repositories.commands.JobCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.JobCommandService;
import org.springframework.stereotype.Service;

@Service
public class JobCommandServiceImpl extends EntityCommandServiceImpl<Job, Long> implements JobCommandService {

    public JobCommandServiceImpl(JobCommandRepository repository) {
        super(repository);
    }
}
