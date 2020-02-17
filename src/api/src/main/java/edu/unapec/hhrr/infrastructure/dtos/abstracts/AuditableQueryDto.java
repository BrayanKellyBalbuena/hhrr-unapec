package edu.unapec.hhrr.infrastructure.dtos.abstracts;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AuditableQueryDto<ID> extends BaseQueryDto<ID> {
    protected LocalDateTime createdDate;
    protected String createdBy;
    protected String modifiedBy;
    protected LocalDateTime modifiedDate;
}
