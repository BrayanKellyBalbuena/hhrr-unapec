package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "institution", indexes = {@Index(name = "idx_institution_isActive", columnList = "is_active"),
        @Index(name = "uidx_institution_name", columnList = "name", unique = true)})
@Where(clause = "is_active=true")
@Data
public class Institution extends Catalog<Long> {
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "institution_id")
    private Set<Training> trainings = new HashSet<>();
}
