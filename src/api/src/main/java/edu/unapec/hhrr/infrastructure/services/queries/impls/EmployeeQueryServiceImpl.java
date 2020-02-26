package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Employee;
import edu.unapec.hhrr.infrastructure.repositories.queries.EmployeeQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.EntityQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.EmployeeQueryService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeQueryServiceImpl extends  EntityQueryServiceImpl<Employee, Long>  implements EmployeeQueryService {

    public EmployeeQueryServiceImpl(EmployeeQueryRepository repository) {
        super(repository);
    }
}
