package edu.unapec.hhrr.infrastructure.dtos.commands.candidate;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.AdultPersonDto;
import lombok.Data;

@Data
public class CandidateCommandDto extends AdultPersonDto<Long> {
    private String email;
}
