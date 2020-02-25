package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.CandidateDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.candidate.CandidateProfileDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.candidate.CandidateQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.job.JobQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.language.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.JobQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/jobs")
@Api(tags = "Jobs")
public class JobsQueryController extends CatalogQueryController<Job, JobQueryDto, Long> {
    private JobQueryService jobQueryService;
    private CandidateQueryService candidateQueryService;

    public JobsQueryController(@Autowired JobQueryService queryService, ModelMapper mapper,
                               @Autowired CandidateQueryService candidateQueryService) {
        super(queryService, Job.class, JobQueryDto.class, mapper);
        this.jobQueryService = queryService;
        this.candidateQueryService = candidateQueryService;
    }


    @GetMapping("/{id}/candidates")
    public ResponseEntity<Page<CandidateQueryDto>> getApplyCandidates(@PathVariable Long id, PageRequestDto pageRequestDto){
        var candidates = candidateQueryService.findAllCandidatesByApplyJobId(id, pageRequestDto);

        return ResponseEntity.ok(candidates.map(c -> mapper.map(c, CandidateQueryDto.class)));
    }
}
