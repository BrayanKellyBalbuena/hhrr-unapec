package edu.unapec.hhrr.core.entities.abstracts;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class Catalog<ID extends Serializable> extends AuditableEntity<ID> {
    @Column(name = "name", nullable = false, length = 128)
    public String name;
    @Column(name = "description", nullable =  true, length = 1024)
    public String description;
}
