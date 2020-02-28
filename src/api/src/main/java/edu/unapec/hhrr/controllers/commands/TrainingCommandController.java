package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.dtos.commands.training.TrainingCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.training.TrainingUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.TrainingCommandService;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/trainings")
@Api(tags = "Trainings")
public class TrainingCommandController extends EntityCommandController<Training, Long, TrainingCreateCommandDto,
        TrainingUpdateCommandDto> {

   private CandidateQueryService candidateQueryService;

    public TrainingCommandController(@Autowired TrainingCommandService commandService, ModelMapper mapper,
          CandidateQueryService  candidateQueryService) {
        super(commandService, Training.class, TrainingCreateCommandDto.class, TrainingUpdateCommandDto.class, mapper );
        this.candidateQueryService = candidateQueryService;
    }


    @Override
    public void create(@Valid @RequestBody TrainingCreateCommandDto trainingCreateCommandDto) {
        var candidate = candidateQueryService.getCurrentCandidate();
        trainingCreateCommandDto.setCandidateId(candidate.getId());
        super.create(trainingCreateCommandDto);
    }
}
