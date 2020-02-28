package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.commands.skill.SkillCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.skill.SkillUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.services.commands.SkillCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/skills")
@Api(tags = "Skills")
public class SkillsCommandController extends EntityCommandController<Skill, Long, SkillCreateCommandDto,
        SkillUpdateCommandDto> {

    public SkillsCommandController(@Autowired SkillCommandService commandService, ModelMapper mapper) {
        super(commandService, Skill.class, SkillCreateCommandDto.class, SkillUpdateCommandDto.class, mapper );
    }
}
