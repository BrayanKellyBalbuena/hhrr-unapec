package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(of = {"name", "description"})
public abstract class CatalogCreateCommand {
    @NotNull(message = "Name cannot be null")
    String name;
    @NotNull(message = "Description cannot be null")
    String description;
}
