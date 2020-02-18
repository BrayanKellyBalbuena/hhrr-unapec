package edu.unapec.hhrr.infrastructure.dtos.commands.training;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogUpdateCommandDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TrainingUpdateCommandDto extends CatalogUpdateCommandDto<Long> {
    @NotNull(message = "Date from is required")
    private LocalDate dateFrom;

    @NotNull(message = "Date to is required")
    private LocalDate dateTo;

    @NotNull(message = "Institution is required")
    private Long institutionId;
}
