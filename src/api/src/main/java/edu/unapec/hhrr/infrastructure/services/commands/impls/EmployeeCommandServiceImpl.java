package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.Employee;
import edu.unapec.hhrr.infrastructure.repositories.commands.EmployeeCommandRepository;
import edu.unapec.hhrr.infrastructure.repositories.commands.EntityCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.EmployeeCommandService;
import edu.unapec.hhrr.infrastructure.services.commands.EntityCommandService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCommandServiceImpl extends EntityCommandServiceImpl<Employee, Long> implements EmployeeCommandService {
    public EmployeeCommandServiceImpl(EmployeeCommandRepository repository) {
        super(repository);
    }
}
