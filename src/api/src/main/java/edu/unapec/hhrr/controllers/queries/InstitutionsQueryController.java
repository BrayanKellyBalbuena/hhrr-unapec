package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.InstitutionQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public Page<InstitutionQueryDto> seachBy(CatalogSeachField searchBy, String seachCriteria,
                                           PageRequestDto pageRequest) {

        if(searchBy == CatalogSeachField.NAME)
            return this.queryService.findByName(seachCriteria,
                    PageRequest.of(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(), Sort.by(pageRequest.getSortDirection(),
                            "name") ))
                    .map(e -> mapper.map(e, dtoClass));
        else if (searchBy == CatalogSeachField.DESCRIPTION) {
            return this.queryService.findByDescription(seachCriteria,
                    PageRequest.of(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(),
                            Sort.by(pageRequest.getSortDirection() , "description") ))
                    .map(e -> mapper.map(e, dtoClass));
        } else  {
            throw new IllegalArgumentException(searchBy.name());
        }
    }
}
