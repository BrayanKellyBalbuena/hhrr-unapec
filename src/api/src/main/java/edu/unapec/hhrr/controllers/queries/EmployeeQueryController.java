package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Employee;
import edu.unapec.hhrr.core.entities.Institution;
import edu.unapec.hhrr.infrastructure.dtos.queries.employee.EmployeeQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.EmployeeQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/employees")
@Api(tags = "Employees")
public class EmployeeQueryController extends  EntityQueryController<Employee, EmployeeQueryDto, Long> {
    public EmployeeQueryController(@Autowired EmployeeQueryService queryService,ModelMapper mapper) {
        super(queryService, Employee.class, EmployeeQueryDto.class, mapper);
    }
}
