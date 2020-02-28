package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.repositories.commands.SkillCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.SkillCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillCommandServiceImpl extends EntityCommandServiceImpl<Skill, Long> implements SkillCommandService {
    public SkillCommandServiceImpl(@Autowired SkillCommandRepository repository) {
        super(repository);
    }
}
