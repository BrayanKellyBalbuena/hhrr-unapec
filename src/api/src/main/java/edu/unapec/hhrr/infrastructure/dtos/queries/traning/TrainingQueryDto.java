package edu.unapec.hhrr.infrastructure.dtos.queries.traning;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TrainingQueryDto extends CatalogQueryDto<Long> {
    @NotNull(message = "Date from is required")
    private LocalDate dateFrom;

    @NotNull(message = "Date to is required")
    private LocalDate dateTo;

    @NotNull(message = "Institution is required")
    private Long institutionId;

    private String institutionName;
}
