package edu.unapec.hhrr.core.entites.abstracts;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = false, updatable = false)
    protected LocalDateTime modifiedDate;
}
