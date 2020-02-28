package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.core.entities.Employee;
import edu.unapec.hhrr.infrastructure.dtos.commands.employee.EmployeeCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.employee.EmployeeUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.exceptions.ResourceNotFoundException;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsImpl;
import edu.unapec.hhrr.infrastructure.services.commands.EmployeeCommandService;
import edu.unapec.hhrr.infrastructure.services.commands.EntityCommandService;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.EmployeeQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.JobQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/employees")
@Api(tags = "Employees")
public class EmployeeCommandController extends EntityCommandController<Employee,Long ,EmployeeCreateCommandDto, EmployeeUpdateCommandDto> {
    private CandidateQueryService candidateQueryService;

    public EmployeeCommandController(@Autowired EmployeeCommandService commandService, ModelMapper mapper,
                                     @Autowired JobQueryService jobQueryService,
                                     @Autowired CandidateQueryService candidateQueryService) {
        super(commandService, Employee.class, EmployeeCreateCommandDto.class, EmployeeUpdateCommandDto.class, mapper);
        this.candidateQueryService = candidateQueryService;
    }
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PostMapping("/contract/{candidateId}")
//    public void contract(@PathVariable Long candidateId) {
//       var candidate =  candidateQueryService.findById(candidateId);
//
//        if (candidate.isPresent()) {
//            var employee = mapper.map(candidate.get(), Employee.class);
//            employee.setId(0L);
//            employee.setHireDate(LocalDateTime.now());
//            commandService.save(employee);
//        } else  {
//            throw new ResourceNotFoundException("Candidate not found");
//        }
//    }
}
