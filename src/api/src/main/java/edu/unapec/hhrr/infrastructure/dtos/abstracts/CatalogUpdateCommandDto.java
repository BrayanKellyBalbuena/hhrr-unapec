package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class CatalogUpdateCommandDto<ID extends Serializable>  extends  EntityUpdateCommandDto<ID> {
    @NotNull(message = "Name cannot be null")
    String name;
    @NotNull(message = "Description cannot be null")
    String description;
}
