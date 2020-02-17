package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.dtos.commands.institution.InstitutionCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.institution.InstitutionUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.InstitutionCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/institutions")
@Api(tags = "Institutions")
public class InstitutionsCommandController extends EntityCommandController<Institution, Long, InstitutionCreateCommandDto,
        InstitutionUpdateCommandDto> {

    public InstitutionsCommandController(@Autowired InstitutionCommandService commandService, ModelMapper mapper) {
        super(commandService, Institution.class, InstitutionCreateCommandDto.class, InstitutionUpdateCommandDto.class, mapper );
    }
}
