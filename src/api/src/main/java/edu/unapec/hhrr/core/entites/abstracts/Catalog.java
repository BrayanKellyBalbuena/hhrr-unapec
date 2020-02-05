package edu.unapec.hhrr.core.entites.abstracts;

import edu.unapec.hhrr.core.entites.abstracts.AuditableEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class Catalog<ID extends Serializable> extends AuditableEntity<ID> {
    @Column(name = "name", nullable = false)
    protected String Name;
}
