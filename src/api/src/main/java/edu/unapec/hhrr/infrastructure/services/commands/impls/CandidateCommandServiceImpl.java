package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.repositories.commands.CandidateCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.CandidateCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateCommandServiceImpl extends EntityCommandServiceImpl<Candidate, Long> implements CandidateCommandService {
    public CandidateCommandServiceImpl(@Autowired CandidateCommandRepository repository) {
        super(repository);
    }
}
