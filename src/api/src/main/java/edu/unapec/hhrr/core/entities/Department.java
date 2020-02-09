package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Department")
@Table(name = "departments", indexes = {@Index(name = "idx_departments_isActive", columnList = "is_active"),
        @Index(name = "uidx_departments_name", columnList = "name", unique = true)})
@Where(clause = "is_active = true")
@Data()
public class Department  extends Catalog<Long> {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();
}
