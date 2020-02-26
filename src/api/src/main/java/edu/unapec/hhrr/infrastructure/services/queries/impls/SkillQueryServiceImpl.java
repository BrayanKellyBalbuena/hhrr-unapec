package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.repositories.queries.SkillQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.SkillQueryService;
import edu.unapec.hhrr.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SkillQueryServiceImpl extends EntityQueryServiceImpl<Skill, Long> implements SkillQueryService {

    private SkillQueryRepository queryRepository;

    public SkillQueryServiceImpl(@Autowired SkillQueryRepository repository) {
        super(repository);
        this.queryRepository = repository;
    }

    @Override
    public Page<Skill> findByName(String name, Pageable pageable) {
       return queryRepository.findByNameContains(name,pageable);
    }

    @Override
    public Page<Skill> findByDescription(String description, Pageable pageable) {
        return queryRepository.findByDescriptionContains(description, pageable);
    }

    @Override
    public Page<Skill> findByCandidateId(Long candidateId, PageRequestDto pageRequestDto) {
        return  this.queryRepository.findByCandidateId(candidateId, Converter.PageRequestDtoToPageable(pageRequestDto));
    }
}
