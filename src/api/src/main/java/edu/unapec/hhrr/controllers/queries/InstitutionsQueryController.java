package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionWithIDAndNameDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillWithIDAndNameQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.InstitutionQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/institutions")
@Api(tags = "Institutions")
@CrossOrigin(origins = "http://localhost:4200")
public class InstitutionsQueryController extends CatalogQueryController<Institution, InstitutionQueryDto, Long> {
    private InstitutionQueryService queryService;

    public InstitutionsQueryController(@Autowired InstitutionQueryService queryService, ModelMapper mapper) {
        super(queryService, Institution.class, InstitutionQueryDto.class, mapper);
        this.queryService = queryService;
    }

    @GetMapping("/institutions_with_id_name")
    public Page<InstitutionWithIDAndNameDto> getInstitutionWithIdAndName(PageRequestDto pageRequestDto){
        return queryService.findAll(pageRequestDto).map(s -> mapper.map(s, InstitutionWithIDAndNameDto.class));
    }

}
