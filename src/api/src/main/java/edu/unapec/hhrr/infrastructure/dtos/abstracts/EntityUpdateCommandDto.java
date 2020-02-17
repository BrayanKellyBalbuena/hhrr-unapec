package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;

@Data
public abstract class EntityUpdateCommandDto<ID> extends AuditableQueryDto<ID> {

}
