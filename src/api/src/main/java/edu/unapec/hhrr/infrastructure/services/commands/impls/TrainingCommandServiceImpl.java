package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.repositories.commands.EntityCommandRepository;
import edu.unapec.hhrr.infrastructure.repositories.commands.TrainingCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.TrainingCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCommandServiceImpl extends EntityCommandServiceImpl<Training, Long> implements TrainingCommandService {
    public TrainingCommandServiceImpl(@Autowired TrainingCommandRepository repository) {
        super(repository);
    }
}
