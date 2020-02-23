package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity()
@Table(name = "work_experience", indexes = {@Index(name = "idx_work_experience_isactive", columnList = "is_active"),
        @Index(name = "idx_work_experience_cantidades", columnList = "candidate_id")
})
@Where(clause = "is_active = true")
@Getter
@Setter
public class WorkExperience extends Catalog<Long> {
    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    @Column(name = "date_to", nullable = false)
    private LocalDate dateTo;

    @Column(nullable = false)
    private Double salary;

    @Column(name = "candidate_id",nullable = false)
    private Long candidateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", foreignKey = @ForeignKey(name = "fk_work_experience_candidate"),
            insertable=false, updatable = false)
    private Candidate candidate;
}
