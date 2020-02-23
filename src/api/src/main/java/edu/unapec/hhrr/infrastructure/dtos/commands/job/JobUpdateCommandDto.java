package edu.unapec.hhrr.infrastructure.dtos.commands.job;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogUpdateCommandDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class JobUpdateCommandDto extends CatalogUpdateCommandDto<Long> {
    @PositiveOrZero(message = "Must have a risk level")
    private long riskLevelId;
    @PositiveOrZero(message = "Max salary must be greater than zero")
    private long mininumSalary;
    @PositiveOrZero(message = "Minimun salary must be greater than zero")
    private long maximunSalary;
}
