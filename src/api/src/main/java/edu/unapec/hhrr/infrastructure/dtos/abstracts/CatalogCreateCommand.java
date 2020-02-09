package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public abstract class CatalogCreateCommand {
    @NotNull(message = "Name cannot be null")
    String name;
    @NotNull(message = "Description cannot be null")
    String description;
}
