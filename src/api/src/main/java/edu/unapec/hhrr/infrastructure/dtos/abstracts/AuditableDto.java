package edu.unapec.hhrr.infrastructure.dtos.abstracts;


import java.time.LocalDateTime;

public abstract class AuditableDto<ID> extends BaseDto<ID> {
    protected LocalDateTime createdDate;
    protected String createdBy;
    protected String modifiedBy;
    protected LocalDateTime modifiedDate;
}
