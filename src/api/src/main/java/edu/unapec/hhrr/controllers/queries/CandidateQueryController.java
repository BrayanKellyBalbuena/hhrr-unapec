package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.candidate.CandidateQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.job.JobQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.language.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.traning.TrainingQueryDto;
import edu.unapec.hhrr.infrastructure.repositories.queries.CandidateQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.LanguageQueryRepository;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsImpl;
import edu.unapec.hhrr.infrastructure.services.queries.*;
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

   private LanguageQueryService languageQueryService;
   private SkillQueryService skillQueryService;

    private CandidateQueryService candidateQueryService;
    private JobQueryService jobQueryService;
    private  TrainingQueryService trainingQueryService;

    public CandidateQueryController(@Autowired CandidateQueryService queryService, @Autowired ModelMapper mapper,
                                    @Autowired JobQueryService jobQueryService,
                                    @Autowired LanguageQueryService languageQueryService,
                                    @Autowired TrainingQueryService trainingQueryService,
                                    @Autowired SkillQueryService skillQueryService) {

        super(queryService, Candidate.class, CandidateQueryDto.class, mapper);
        this.candidateQueryService = queryService;
        this.jobQueryService = jobQueryService;
        this.languageQueryService = languageQueryService;
        this.trainingQueryService = trainingQueryService;
        this.skillQueryService = skillQueryService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_skills")
    public Page<SkillQueryDto> getSkills(PageRequestDto pageRequestDto) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var c = candidateQueryService.findByUserId( current.getId()).get();

        return this.skillQueryService
                .findByCandidateId(c.getId(), pageRequestDto).map(e -> mapper.map(e, SkillQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/skills")
    public Page<SkillQueryDto> getSkills(@PathVariable Long id,PageRequestDto pageRequestDto) {

        return this.skillQueryService
                .findByCandidateId(id, pageRequestDto).map(e -> mapper.map(e, SkillQueryDto.class));
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/not_assign_languages")
    public Page<LanguagueQueryDto> getNoAssingLanguages(PageRequestDto pageRequestDto) {

        return  this.languageQueryService
                .findAllNotMatchCandidate(this.candidateQueryService.getCurrentCandidate().getId(),
                        pageRequestDto).map(e -> mapper.map(e, LanguagueQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_languages")
    public Page<LanguagueQueryDto> getLanguages(PageRequestDto pageRequestDto) {

        return this.languageQueryService.
                findByCandidatesId(this.candidateQueryService.getCurrentCandidate().getId(), pageRequestDto).
                map(c -> mapper.map(c, LanguagueQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/languages")
    public Page<LanguagueQueryDto> getLanguages(@PathVariable Long id,PageRequestDto pageRequestDto) {

        return this.languageQueryService.
                findByCandidatesId(id, pageRequestDto).
                map(c -> mapper.map(c, LanguagueQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/jobs")
    public Page<JobQueryDto> getJobs(PageRequestDto pageRequestDto) {
        return this.jobQueryService
                .findByCandidatesId(this.candidateQueryService.getCurrentCandidate().getId(), pageRequestDto)
                .map(j -> mapper.map(j, JobQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/jobs")
    public Page<JobQueryDto> getJobs(@PathVariable Long id, PageRequestDto pageRequestDto) {
        return this.jobQueryService
                .findByCandidatesId(id, pageRequestDto)
                .map(j -> mapper.map(j, JobQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/jobs/no_apply")
    public Page<JobQueryDto> getNoApplyJobs(PageRequestDto pageRequestDto) {
        return this.jobQueryService
                .findAllNotMatchCandidate(this.candidateQueryService.getCurrentCandidate().getId(), pageRequestDto)
                .map(j -> mapper.map(j, JobQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/trainings")
    public Page<TrainingQueryDto> getTrainings(PageRequestDto pageRequestDto) {
        return this.trainingQueryService
                .findByCandidateId(this.candidateQueryService.getCurrentCandidate().getId(), pageRequestDto)
                .map(j -> mapper.map(j, TrainingQueryDto .class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/trainings")
    public Page<TrainingQueryDto> getTrainings( @PathVariable Long id, PageRequestDto pageRequestDto) {
        return this.trainingQueryService
                .findByCandidateId(id, pageRequestDto)
                .map(j -> mapper.map(j, TrainingQueryDto .class));
    }

}
