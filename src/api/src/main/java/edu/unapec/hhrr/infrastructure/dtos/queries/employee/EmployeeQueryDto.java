package edu.unapec.hhrr.infrastructure.dtos.queries.employee;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.AuditableQueryDto;

public class EmployeeQueryDto extends AuditableQueryDto<Long> {
    private String identityCard;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
}
