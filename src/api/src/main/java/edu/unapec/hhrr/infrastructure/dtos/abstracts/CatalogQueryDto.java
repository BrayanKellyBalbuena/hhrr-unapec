package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class CatalogQueryDto<ID> extends AuditableQueryDto<ID> {
    @NotBlank
    protected String name;
    @NotNull
    protected  String description;
}
