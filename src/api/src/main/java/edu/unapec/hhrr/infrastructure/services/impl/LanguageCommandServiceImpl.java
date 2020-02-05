package edu.unapec.hhrr.infrastructure.services.impl;

import edu.unapec.hhrr.core.entites.Language;
import edu.unapec.hhrr.infrastructure.repositories.LanguageRepository;
import edu.unapec.hhrr.infrastructure.services.LanguageCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageCommandServiceImpl extends CommandServiceImpl<Language, Long> implements LanguageCommandService {
    public LanguageCommandServiceImpl(@Autowired LanguageRepository repository) {
        super(repository);
    }
}
