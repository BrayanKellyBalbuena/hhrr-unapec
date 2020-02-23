package edu.unapec.hhrr.infrastructure.dtos.abstracts;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class AuditableQueryDto<ID> extends BaseQueryDto<ID> {
    protected LocalDateTime createdDate;
    protected String createdBy;
    protected String modifiedBy;
    protected LocalDateTime modifiedDate;
}
