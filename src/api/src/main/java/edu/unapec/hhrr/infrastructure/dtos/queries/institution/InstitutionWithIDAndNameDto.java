package edu.unapec.hhrr.infrastructure.dtos.queries.institution;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogWithIdAndNameQueryDto;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class InstitutionWithIDAndNameDto extends CatalogWithIdAndNameQueryDto<Long> {
}
