package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

@Data
public abstract class BaseQueryDto<ID> extends BaseDto<ID> {
    protected boolean isActive;
    protected long version;
}
