package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public abstract class CatalogQueryDto<ID> extends AuditableQueryDto<ID> {
    @NotBlank
    protected String name;
    @NotNull
    protected  String description;
}
