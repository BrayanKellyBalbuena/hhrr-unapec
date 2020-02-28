package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class CandidateDto {
    @NotBlank(message = "LastName can't be blank")
    @Size(min = 11, max = 11)
     String identityCard = "";

    @NotBlank(message = "FirstName can't be blank")
    String firstName = "";

    @NotBlank(message = "LastName can't be blank")
    String lastName="";

    @Email()
    @NotBlank(message = "LastName can't be blank")
    String email="";

    @Min(value = 18,message = "Age must be than age")
    short age = 18;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateDto)) return false;
        CandidateDto that = (CandidateDto) o;
        return Objects.equal(identityCard, that.identityCard);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identityCard);
    }
}
