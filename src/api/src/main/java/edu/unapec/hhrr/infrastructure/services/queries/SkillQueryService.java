package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;

public interface SkillQueryService extends CatalogQueryService<Skill, Long> {
   Page<Skill> findByCandidateId(Long candidateId, PageRequestDto pageRequestDto);
}
