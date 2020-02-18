package edu.unapec.hhrr.controllers.queries;


import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillWithIDAndNameQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.SkillQueryService;
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
@RequestMapping("/api/skills")
@Api(tags = "Skills")
public class SkillsQueryController extends CatalogQueryController<Skill, SkillQueryDto, Long> {
    private SkillQueryService queryService;

    public SkillsQueryController(@Autowired SkillQueryService queryService, ModelMapper mapper) {
        super(queryService, Skill.class, SkillQueryDto.class, mapper);
        this.queryService = queryService;
    }


    @GetMapping("/skill_with_id_name")
    public Page<SkillWithIDAndNameQueryDto> getSkillWithIdAndNam(PageRequestDto pageRequestDto){
        return queryService.findAll(pageRequestDto).map(s -> mapper.map(s, SkillWithIDAndNameQueryDto.class));
    }
}
