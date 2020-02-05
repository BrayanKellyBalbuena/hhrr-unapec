package edu.unapec.hhrr.infrastructure.services.impl;

import edu.unapec.hhrr.core.entites.Language;
import edu.unapec.hhrr.infrastructure.repositories.LanguageRepository;
import edu.unapec.hhrr.infrastructure.services.LanguageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageQueryServiceImpl extends EntityQueryServiceImpl<Language, Long> implements LanguageQueryService {

    public LanguageQueryServiceImpl(@Autowired LanguageRepository repository) {
        super(repository);
    }
}
