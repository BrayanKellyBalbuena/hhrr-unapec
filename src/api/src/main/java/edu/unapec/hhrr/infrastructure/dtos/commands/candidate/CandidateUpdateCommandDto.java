package edu.unapec.hhrr.infrastructure.dtos.commands.candidate;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.EntityUpdateCommandDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CandidateUpdateCommandDto extends EntityUpdateCommandDto<Long> {

    @NotBlank(message = "LastName can't be blank")
    @Size(min = 11, max = 11)
    private String identityCard;

    @NotBlank(message = "FirstName can't be blank")
    private String firstName;

    @NotBlank(message = "LastName can't be blank")
    private String lastName;

    @Email()
    @NotBlank(message = "LastName can't be blank")
    private String email;

    @Min(value = 18,message = "Age must be than age")
    private short age;

    @NotBlank(message = "Password can't be blank")
    private String password;

    @NotBlank(message = "UserName can't be blank")
    private String userName;
}
