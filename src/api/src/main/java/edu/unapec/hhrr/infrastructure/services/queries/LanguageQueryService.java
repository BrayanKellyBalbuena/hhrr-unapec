package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface LanguageQueryService extends CatalogQueryService<Language, Long> {
    Page<Language> findByCandidatesId(long userId, PageRequestDto pageRequestDto);
    Page<Language> findAllNotMatchCandidate(long userId, PageRequestDto pageRequestDto);
}
