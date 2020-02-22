package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.LanguageCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/languages")
@Api(tags = "Languages")
public class LanguagesCommandController extends EntityCommandController<Language, Long, LanguageCreateCommandDto,
        LanguageUpdateCommandDto> {
    public LanguagesCommandController(LanguageCommandService commandService, ModelMapper mapper) {
        super(commandService,Language.class, LanguageCreateCommandDto.class, LanguageUpdateCommandDto.class, mapper );
    }
}
