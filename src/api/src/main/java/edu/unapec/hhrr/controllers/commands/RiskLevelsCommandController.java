package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.dtos.commands.risklavel.RiskLevelCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.risklavel.RiskLevelUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.RiskLevelCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/risk_levels")
@Api(tags = "RiskLevels")
public class RiskLevelsCommandController  extends EntityCommandController<RiskLevel, Long, RiskLevelCreateCommandDto,
        RiskLevelUpdateCommandDto> {
    public RiskLevelsCommandController(@Autowired RiskLevelCommandService commandService, ModelMapper mapper) {
        super(commandService, RiskLevel.class, RiskLevelCreateCommandDto.class, RiskLevelUpdateCommandDto.class, mapper );
    }
}
