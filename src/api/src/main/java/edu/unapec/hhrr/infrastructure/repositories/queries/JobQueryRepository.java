package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobQueryRepository extends EntityQueryRepository<Job, Long> {
    Page<Job> findByNameContains(String name, Pageable pageable);
    Page<Job> findByDescriptionContains(String description, Pageable pageable);
}
