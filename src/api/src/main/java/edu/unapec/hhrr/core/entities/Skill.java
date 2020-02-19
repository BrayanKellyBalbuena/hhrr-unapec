package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "skills", indexes = {@Index(name = "idx_skill_isActive", columnList = "is_active"),
        @Index(name = "uidx_skills_name", columnList = "name", unique = true)})
@Where(clause = "is_active = true")
public class Skill extends Catalog<Long> {
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    private Set<Candidate> candidates = new HashSet<>();
}
