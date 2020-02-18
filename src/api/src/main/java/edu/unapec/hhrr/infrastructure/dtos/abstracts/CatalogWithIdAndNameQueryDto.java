package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

@Data
public abstract class CatalogWithIdAndNameQueryDto<ID>  extends BaseDto<ID>{
    private String name;
}
