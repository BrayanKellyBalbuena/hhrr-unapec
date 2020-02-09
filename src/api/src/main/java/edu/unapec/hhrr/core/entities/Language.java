package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Where(clause = "is_active = true")
@Table(name="languages", indexes = {@Index(name = "idx_language_isActive", columnList = "is_active"),
        @Index( name = "uidx_language_name", columnList = "name", unique = true)})
public class Language extends Catalog<Long> {
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "languages")
    private Set<Candidate> candidates = new HashSet<>();
}
