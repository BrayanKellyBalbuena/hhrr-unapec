package edu.unapec.hhrr.infrastructure.dtos.commands.institution;

import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogCreateCommand;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class InstitutionCreateCommandDto extends CatalogCreateCommand {
}
