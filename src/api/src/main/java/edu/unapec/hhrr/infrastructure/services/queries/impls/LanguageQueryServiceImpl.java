package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.repositories.queries.LanguageQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageQueryServiceImpl extends EntityQueryServiceImpl<Language, Long> implements LanguageQueryService {
    public LanguageQueryServiceImpl(@Autowired LanguageQueryRepository repository) {
        super(repository);
    }
}
