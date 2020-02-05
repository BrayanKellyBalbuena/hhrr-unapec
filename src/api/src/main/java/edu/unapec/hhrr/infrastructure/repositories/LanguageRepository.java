package edu.unapec.hhrr.infrastructure.repositories;

import edu.unapec.hhrr.core.entites.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LanguageRepository extends PagingAndSortingRepository<Language, Long> {
   Page<Language> findByName(String name, Pageable pageable);
}
