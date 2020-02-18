package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.language.LanguagueQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/languages")
@Api(tags = "Languages")
public class LanguagesQueryController extends CatalogQueryController<Language, LanguagueQueryDto, Long> {
    private LanguageQueryService languageQueryService;

   public LanguagesQueryController(@Autowired LanguageQueryService queryService, ModelMapper mapper) {
       super(queryService,Language.class, LanguagueQueryDto.class, mapper);
       this.languageQueryService = queryService;
   }
}
