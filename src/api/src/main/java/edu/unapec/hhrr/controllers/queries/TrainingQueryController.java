package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Training;
import edu.unapec.hhrr.infrastructure.dtos.queries.traning.TrainingQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.TrainingQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/trainings")
@Api(tags = "Trainings")
public class TrainingQueryController extends CatalogQueryController<Training, TrainingQueryDto, Long> {
    private TrainingQueryService trainingQueryService;

    public TrainingQueryController(@Autowired TrainingQueryService queryService, ModelMapper mapper) {
        super(queryService, Training.class, TrainingQueryDto.class, mapper);
        this.trainingQueryService = queryService;
    }
}
