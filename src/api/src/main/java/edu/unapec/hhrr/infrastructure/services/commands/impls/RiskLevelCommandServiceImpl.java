package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.RiskLevel;
import edu.unapec.hhrr.infrastructure.repositories.commands.RiskLevelCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.RiskLevelCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiskLevelCommandServiceImpl extends EntityCommandServiceImpl<RiskLevel, Long> implements RiskLevelCommandService {
    public RiskLevelCommandServiceImpl(@Autowired RiskLevelCommandRepository repository) {
        super(repository);
    }
}
