package edu.unapec.hhrr.core.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass()
public abstract class Person<ID extends Serializable> extends AuditableEntity<ID> {
    @Column(name = "first_name", nullable = false, length = 64)
    protected String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    protected String lastName;

    @Column(nullable = false)
    protected int age;
}
