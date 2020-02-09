package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Person;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Candidate")
@Where(clause = "is_active = true")
@Table(name = "candidates", indexes = {@Index(name = "idx_candidates_isActive", columnList = "is_active"),
        @Index(name = "idx_employees_firstName", columnList = "first_name"),
        @Index(name = "idx_employees_last_name", columnList = "last_name")})
public class Candidate extends Person<Long> {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
    private Set<WorkExperience> workExperiences = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "candidates_skills",
            joinColumns = @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_cantidates_skills_candidates")),
            inverseJoinColumns = @JoinColumn(name = "skill_id", foreignKey = @ForeignKey(name = "fk_cantidates_skills_skills"))
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "cantidates_languagues",
            joinColumns = @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_cantidates_languagues_candidate")),
            inverseJoinColumns = @JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "fk_cantidates_languagues_languages")))
    private Set<Language> languages = new HashSet<>();
}
