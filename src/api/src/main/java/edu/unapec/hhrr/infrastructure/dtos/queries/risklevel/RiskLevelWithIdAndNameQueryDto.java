package edu.unapec.hhrr.infrastructure.dtos.queries.risklevel;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.BaseDto;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogWithIdAndNameQueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class RiskLevelWithIdAndNameQueryDto extends CatalogWithIdAndNameQueryDto<Long> {

}
