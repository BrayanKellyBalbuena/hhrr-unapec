package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.dtos.commands.training.TrainingCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.training.TrainingUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.TrainingCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("trainings")
@Api(tags = "Trainings")
public class TrainingCommandController extends EntityCommandController<Training, Long, TrainingCreateCommandDto,
        TrainingUpdateCommandDto> {

    public TrainingCommandController(@Autowired TrainingCommandService commandService, ModelMapper mapper) {
        super(commandService, Training.class, TrainingCreateCommandDto.class, TrainingUpdateCommandDto.class, mapper );
    }
}
