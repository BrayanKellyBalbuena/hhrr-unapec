package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.repositories.queries.LanguageQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import edu.unapec.hhrr.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LanguageQueryServiceImpl extends EntityQueryServiceImpl<Language, Long> implements  LanguageQueryService {

    private LanguageQueryRepository languageQueryRepository;

    public LanguageQueryServiceImpl(@Autowired LanguageQueryRepository repository) {
        super(repository);
        this.languageQueryRepository = repository;
    }

    @Override
    public Page<Language> findByName(String name, Pageable pageable) {
       return languageQueryRepository.findByNameContains(name, pageable);
    }

    @Override
    public Page<Language> findByDescription(String description, Pageable pageable) {
       return languageQueryRepository.findByDescriptionContains(description, pageable);
    }


    public Page<Language> findAllNotMatchCandidate(long userId, PageRequestDto pageRequestDto) {
      return languageQueryRepository.
              findAllNotMatchCandidate(userId, Converter.PageRequestDtoToPageable(pageRequestDto));
    }

    @Override
    public Page<Language> findByCandidatesId(long userId, PageRequestDto pageRequestDto) {
        return languageQueryRepository.findByCandidatesId(userId, Converter.PageRequestDtoToPageable(pageRequestDto));
    }
}

