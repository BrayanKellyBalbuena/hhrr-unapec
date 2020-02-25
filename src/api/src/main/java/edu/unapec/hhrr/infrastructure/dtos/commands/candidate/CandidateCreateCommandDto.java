package edu.unapec.hhrr.infrastructure.dtos.commands.candidate;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CandidateDto;
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
public class CandidateCreateCommandDto extends CandidateDto {

    @NotBlank(message = "Password can't be blank")
    private String password;

    @NotBlank(message = "UserName can't be blank")
    private String userName;
}
