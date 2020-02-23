package edu.unapec.hhrr.infrastructure.dtos.queries.traning;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TrainingQueryDto extends CatalogQueryDto<Long> {
    @NotNull(message = "Date from is required")
    private LocalDate dateFrom;

    @NotNull(message = "Date to is required")
    private LocalDate dateTo;

    @NotNull(message = "Institution is required")
    private Long institutionId;

    private String institutionName;
}
