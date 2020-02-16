package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public abstract class CatalogQueryDto<ID> extends AuditableQueryQueryDto<ID> {
    @NotNull
    protected String name;
    @NotNull
    protected  String description;
}
