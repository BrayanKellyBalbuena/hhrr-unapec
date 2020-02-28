package edu.unapec.hhrr.infrastructure.dtos.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public abstract class EntityUpdateCommandDto<ID> extends BaseDto<ID> {
    long version;
}
