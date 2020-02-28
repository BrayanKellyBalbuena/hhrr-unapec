package edu.unapec.hhrr.infrastructure.dtos.queries.candidate;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.AuditableQueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CandidateQueryDto extends AuditableQueryDto<Long> {
    private String identityCard;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
    private Boolean isEmployee;
}
