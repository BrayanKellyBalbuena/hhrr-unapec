package edu.unapec.hhrr.infrastructure.dtos.commands.training;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogCreateCommand;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TrainingCreateCommandDto extends CatalogCreateCommand {
    @NotNull(message = "Date from is required")
    private LocalDate dateFrom;

    @NotNull(message = "Date to is required")
    private LocalDate dateTo;

    @NotNull(message = "Institution is required")
    private Long institutionId;

    private Long candidateId;
}
