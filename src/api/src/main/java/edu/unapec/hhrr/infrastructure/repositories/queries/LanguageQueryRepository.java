package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LanguageQueryRepository extends EntityQueryRepository<Language, Long> {

}
