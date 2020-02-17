package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.risklevel.RiskLevelQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.RiskLevelQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/risk_levels")
@Api(tags = "RiskLevels")
public class RiskLevelsQueryController extends CatalogQueryController<RiskLevel, RiskLevelQueryDto, Long> {
    private RiskLevelQueryService queryService;

    public RiskLevelsQueryController(@Autowired RiskLevelQueryService queryService, ModelMapper mapper) {
        super(queryService, RiskLevel.class, RiskLevelQueryDto.class, mapper);
        this.queryService = queryService;
    }

    @Override
    public Page<RiskLevelQueryDto> seachBy(CatalogSeachField searchBy, String seachCriteria,
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
