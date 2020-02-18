package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.InstitutionQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/institutions")
@Api(tags = "Institutions")
public class InstitutionsQueryController extends CatalogQueryController<Institution, InstitutionQueryDto, Long> {
    private InstitutionQueryService queryService;

    public InstitutionsQueryController(@Autowired InstitutionQueryService queryService, ModelMapper mapper) {
        super(queryService, Institution.class, InstitutionQueryDto.class, mapper);
        this.queryService = queryService;
    }

}
