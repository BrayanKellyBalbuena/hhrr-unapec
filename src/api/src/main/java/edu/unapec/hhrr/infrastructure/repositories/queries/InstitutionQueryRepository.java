package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.core.entities.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InstitutionQueryRepository extends EntityQueryRepository<Institution, Long> {
    Page<Institution> findByNameContains(String name, Pageable pageable);
    Page<Institution> findByDescriptionContains(String name, Pageable pageable);
}
