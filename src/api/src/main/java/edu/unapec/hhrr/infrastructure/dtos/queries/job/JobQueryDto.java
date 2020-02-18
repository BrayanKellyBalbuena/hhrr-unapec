package edu.unapec.hhrr.infrastructure.dtos.queries.job;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import lombok.Data;

import javax.validation.constraints.NegativeOrZero;

@Data
public class JobQueryDto extends CatalogQueryDto<Long> {
    private long riskLevelId;
    private String riskLevel;
    private double mininumSalary;
    private double maximunSalary;
}
