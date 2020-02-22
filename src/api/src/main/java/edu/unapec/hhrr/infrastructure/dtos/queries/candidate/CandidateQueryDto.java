package edu.unapec.hhrr.infrastructure.dtos.queries.candidate;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.AuditableQueryDto;
import lombok.Data;

@Data
public class CandidateQueryDto extends AuditableQueryDto<Long> {
    private short identityCard;
    private String firstName;
    private String lastName;
    private String email;
    private short age;
}
