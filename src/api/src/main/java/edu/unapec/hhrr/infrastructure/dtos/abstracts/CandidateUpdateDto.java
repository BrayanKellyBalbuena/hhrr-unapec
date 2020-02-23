package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class CandidateUpdateDto<ID> extends AuditableQueryDto<ID> {
    @NotBlank(message = "Identity card can't be blank")
    @Size(min = 11, max = 11, message = "Identity card must be 11 digits")
    private short identityCard;

    @NotBlank(message = "FirstName can't be blank")
    protected String firstName;

    @NotBlank(message = "LastName can't be blank")
    protected String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "LastName can't be blank")
    protected String email;

    @Min(value = 18,message = "Age must be than age")
    protected short age;
}
