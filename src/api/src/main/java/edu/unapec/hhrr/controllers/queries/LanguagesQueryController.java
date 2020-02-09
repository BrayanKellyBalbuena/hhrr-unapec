package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.queries.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/languages")
@Api(tags = "Languages")
public class LanguagesQueryController extends EntityQueryController<Language, LanguagueQueryDto, Long> {
   public LanguagesQueryController(LanguageQueryService queryService,ModelMapper mapper) {
       super(queryService,Language.class, LanguagueQueryDto.class, mapper);
   }
}
