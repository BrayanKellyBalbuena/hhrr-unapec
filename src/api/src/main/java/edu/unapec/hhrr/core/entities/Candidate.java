package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AdultPerson;
import edu.unapec.hhrr.core.entities.abstracts.Person;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Candidate")
@Where(clause = "is_active = true")
@Table(name = "candidates", indexes = {@Index(name = "idx_candidates_isActive", columnList = "is_active"),
        @Index(name = "idx_candidates_first_name", columnList = "first_name"),
        @Index(name = "idx_candidates_last_name", columnList = "last_name")})
@Data
public class Candidate extends AdultPerson<Long> {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
    private Set<WorkExperience> workExperiences = new HashSet<>();

    @NotNull
    @Column(name = "user_id", length = 64)
    private Long userId;

    @NotNull
    private String email;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "id", insertable=false, updatable = false)
    private User user;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "candidates_skills",
            joinColumns = @JoinColumn(name = "candidate_id",
                    foreignKey = @ForeignKey(name = "fk_cantidates_skills_candidates")),
            inverseJoinColumns = @JoinColumn(name = "skill_id",
                    foreignKey = @ForeignKey(name = "fk_cantidates_skills_skills"))
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.LAZY)
    @JoinTable(name = "cantidates_languagues",
            joinColumns = @JoinColumn(name = "candidate_id", foreignKey =
            @ForeignKey(name = "fk_cantidates_languagues_candidate")),
            inverseJoinColumns = @JoinColumn(name = "language_id",
                    foreignKey = @ForeignKey(name = "fk_cantidates_languagues_languages")))
    private Set<Language> languages = new HashSet<>();
}
