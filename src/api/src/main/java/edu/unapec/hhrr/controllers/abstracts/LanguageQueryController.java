package edu.unapec.hhrr.controllers.abstracts;

import edu.unapec.hhrr.controllers.queries.EntityQueryController;
import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.services.queries.LanguageQueryService;
import edu.unapec.hhrr.infrastructure.services.commands.LanguageCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/languages")
//
//@Api(tags = "Languages")
//public class LanguageQueryController extends EntityQueryController<Language, Language, Long> {
//
//    private LanguageQueryService service;
//    private LanguageCommandService serviceCommand;
//
//    public LanguageQueryController(@Autowired LanguageQueryService queryService, @Autowired LanguageCommandService serviceCommand) {
//        super(queryService);
//        this.serviceCommand = serviceCommand;
//    }
//}
