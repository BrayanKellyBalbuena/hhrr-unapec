package edu.unapec.hhrr.core.entities.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public  class AuditableEntity<ID extends Serializable> extends BaseEntity<ID> {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "modified_date", nullable = true, updatable = false)
    protected LocalDateTime modifiedDate;

    @Column(name = "created_by", length = 64)
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by", length = 64)
    @LastModifiedBy
    private String modifiedBy;
}
