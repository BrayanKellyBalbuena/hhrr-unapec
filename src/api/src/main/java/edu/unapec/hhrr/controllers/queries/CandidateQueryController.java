package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.dtos.queries.candidate.CandidateQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.language.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillQueryDto;
import edu.unapec.hhrr.infrastructure.repositories.queries.CandidateQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.LanguageQueryRepository;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsImpl;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.CatalogQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/candidates")
@Api(tags = "Candidates")
public class CandidateQueryController extends EntityQueryController<Candidate, CandidateQueryDto, Long>  {

    @Autowired
    LanguageQueryService languageQueryService;

    @Autowired
    LanguageQueryRepository languageQueryRepository;
    @Autowired
    CandidateQueryRepository candidateQueryRepository;

    public CandidateQueryController(CandidateQueryService queryService, ModelMapper mapper) {
        super(queryService, Candidate.class, CandidateQueryDto.class, mapper);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/not_assign_languages")
    public Page<LanguagueQueryDto> getNoAssingLanguages(Pageable pageable) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var c = candidateQueryRepository.findByUserId ( current.getId()).get();

        return  this.languageQueryRepository.findAllNotMatchCandidate(c.getId(), pageable).map(e -> mapper.map(e, LanguagueQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_languages")
    public Page<LanguagueQueryDto> getLanguages(Pageable pageable) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var candidate = candidateQueryRepository.findByUserId( current.getId()).get();

        return this.languageQueryRepository.
                findByCandidatesId(candidate.getId(), pageable).
                map(e -> mapper.map(e, LanguagueQueryDto.class));
    }

}
