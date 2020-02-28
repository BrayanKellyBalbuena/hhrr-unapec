package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.repositories.commands.InstitutionCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.InstitutionCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionCommandServiceImpl extends EntityCommandServiceImpl<Institution, Long>
        implements InstitutionCommandService {
    public InstitutionCommandServiceImpl(@Autowired InstitutionCommandRepository repository) {
        super(repository);
    }
}
