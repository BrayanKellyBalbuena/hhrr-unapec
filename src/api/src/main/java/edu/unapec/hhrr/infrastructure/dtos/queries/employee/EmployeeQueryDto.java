package edu.unapec.hhrr.infrastructure.dtos.queries.employee;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.AuditableQueryDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class EmployeeQueryDto extends AuditableQueryDto<Long> {
    private String identityCard;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
    private LocalDate hireDate;
}
