package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.commands.job.JobCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.job.JobUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.JobCommandService;
import edu.unapec.hhrr.infrastructure.services.commands.LanguageCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/jobs")
@Api(tags = "Jobs")
public class JobsCommandController extends EntityCommandController<Job, Long, JobCreateCommandDto,
        JobUpdateCommandDto> {
    public JobsCommandController(JobCommandService commandService, ModelMapper mapper) {
        super(commandService,Job.class, JobCreateCommandDto.class, JobUpdateCommandDto.class, mapper );
    }
}
