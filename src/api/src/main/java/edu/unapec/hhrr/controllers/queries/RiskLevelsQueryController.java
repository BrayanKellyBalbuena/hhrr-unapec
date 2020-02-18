package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.risklevel.RiskLevelQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.risklevel.RiskLevelWithIdAndNameQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillWithIDAndNameQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.RiskLevelQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/risk_levels")
@Api(tags = "Risk Levels")
public class RiskLevelsQueryController extends CatalogQueryController<RiskLevel, RiskLevelQueryDto, Long> {
    private RiskLevelQueryService queryService;

    public RiskLevelsQueryController(@Autowired RiskLevelQueryService queryService, ModelMapper mapper) {
        super(queryService, RiskLevel.class, RiskLevelQueryDto.class, mapper);
        this.queryService = queryService;
    }

    @GetMapping("/risk_level_with_id_name")
    public Page<RiskLevelWithIdAndNameQueryDto> getJobsWithIdAndNam(PageRequestDto pageRequestDto){
        return queryService.findAll(pageRequestDto).map(s -> mapper.map(s, RiskLevelWithIdAndNameQueryDto.class));
    }
}
