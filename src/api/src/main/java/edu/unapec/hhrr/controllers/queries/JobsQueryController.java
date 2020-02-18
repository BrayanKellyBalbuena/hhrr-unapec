package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.queries.job.JobQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.language.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.JobQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/jobs")
@Api(tags = "Jobs")
public class JobsQueryController extends CatalogQueryController<Job, JobQueryDto, Long> {
    private JobQueryService jobQueryService;

    public JobsQueryController(@Autowired JobQueryService queryService, ModelMapper mapper) {
        super(queryService, Job.class, JobQueryDto.class, mapper);
        this.jobQueryService = queryService;
    }
}
