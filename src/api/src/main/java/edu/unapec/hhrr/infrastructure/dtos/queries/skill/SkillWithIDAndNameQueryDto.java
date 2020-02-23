package edu.unapec.hhrr.infrastructure.dtos.queries.skill;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogWithIdAndNameQueryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SkillWithIDAndNameQueryDto extends CatalogWithIdAndNameQueryDto<Long> {

}

