package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.core.entities.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainingQueryRepository extends EntityQueryRepository<Training, Long> {
    Page<Training> findByNameContains(String name, Pageable pageable);
    Page<Training> findByDescriptionContains(String description, Pageable pageable);
}
