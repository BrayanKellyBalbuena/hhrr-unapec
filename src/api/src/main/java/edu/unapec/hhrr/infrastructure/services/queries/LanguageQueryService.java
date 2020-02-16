package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LanguageQueryService extends EntityQueryService<Language, Long> {
    Page<Language> findByName(String name, Pageable pageable);
    Page<Language> findByDescription(String name, Pageable pageable);
}
