package edu.unapec.hhrr.infrastructure.dtos.queries.job;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NegativeOrZero;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class JobQueryDto extends CatalogQueryDto<Long> {
    private long riskLevelId;
    private String riskLevelName;
    private double mininumSalary;
    private double maximunSalary;
    private Long numberOfApplications;
}
