package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AdultPerson;
import edu.unapec.hhrr.core.entities.abstracts.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
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
    @JoinTable(name = "candidates_languages",
            joinColumns = @JoinColumn(name = "candidate_id", foreignKey =
            @ForeignKey(name = "fk_candidates_languagues_candidate")),
            inverseJoinColumns = @JoinColumn(name = "language_id",
                    foreignKey = @ForeignKey(name = "fk_cantidates_languagues_languages")))
    private Set<Language> languages = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "jobs_candidates",
            joinColumns = @JoinColumn(name = "candidate_id",
                    foreignKey = @ForeignKey(name = "fk_jobs_cantidates_candidates")),
            inverseJoinColumns = @JoinColumn(name = "job_id",
                    foreignKey = @ForeignKey(name = "fk_jobs_cantidates_jobs"))
    )
    private Set<Job> jobs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Set<Training> trainings = new HashSet<>();

    @Override()
    public String toString() {
        var stringBuilder = new  StringBuilder();
        stringBuilder.append("Id:" + this.getId());
        stringBuilder.append("First name:" + this.getFirstName());
        stringBuilder.append("Last name:" + this.getLastName());
        return stringBuilder.toString();
    }
}
