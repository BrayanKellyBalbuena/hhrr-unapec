package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;

public interface TrainingQueryService extends CatalogQueryService<Training, Long> {
    Page<Training> findByCandidateId(Long userId, PageRequestDto pageRequestDto);
}
