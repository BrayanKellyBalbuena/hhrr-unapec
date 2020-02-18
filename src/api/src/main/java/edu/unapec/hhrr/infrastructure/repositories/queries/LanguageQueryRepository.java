package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LanguageQueryRepository extends EntityQueryRepository<Language, Long> {
   Page<Language> findByNameContains(String name, Pageable pageable);
   Page<Language> findByDescriptionContains(String description, Pageable pageable);
}
