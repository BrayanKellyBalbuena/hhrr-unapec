package edu.unapec.hhrr.infrastructure.dtos.commands.risklavel;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogUpdateCommandDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class RiskLevelUpdateCommandDto extends CatalogUpdateCommandDto<Long> {
}
