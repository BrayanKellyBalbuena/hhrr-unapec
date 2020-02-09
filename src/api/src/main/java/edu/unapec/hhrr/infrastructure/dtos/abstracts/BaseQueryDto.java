package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

@Data
public abstract class BaseQueryDto<ID> {
    protected ID id;
    protected boolean isActive;
}
