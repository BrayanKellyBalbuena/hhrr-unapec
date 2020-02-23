package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobQueryService extends CatalogQueryService<Job, Long> {
    Page<Job> findByCandidatesId(long userId, PageRequestDto pageRequestDto);
    Page<Job> findAllNotMatchCandidate(long userId, PageRequestDto pageRequestDto);
}
