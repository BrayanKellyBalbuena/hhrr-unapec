package edu.unapec.hhrr.core.entities.abstracts;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
@Data
@Table(indexes = {@Index( name = "idx_active", columnList = "active", unique = true),
@Index(name = "idx_version", columnList = "version")})
public abstract class BaseEntity<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @Column(name = "is_active", nullable = false)
    protected boolean isActive;

    @Version
    protected long version;
}
