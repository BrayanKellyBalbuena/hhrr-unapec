package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.repositories.commands.LanguageCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.LanguageCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageCommandServiceImpl extends EntityCommandServiceImpl<Language, Long> implements LanguageCommandService {
    public LanguageCommandServiceImpl(@Autowired LanguageCommandRepository repository) {
        super(repository);
    }
}
