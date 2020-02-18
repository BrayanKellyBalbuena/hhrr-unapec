package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "trainings",indexes = {@Index(name = "idx_training_isActive", columnList = "is_active"),
        @Index(name = "uidx_trainings_name", columnList = "name",unique = true)})
@Where(clause = "is_active = true")
@Data
public class Training extends Catalog<Long> {
    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    @Column(name = "date_to", nullable = false)
    private LocalDate dateTo;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", foreignKey = @ForeignKey(name = "fk_trainings_institution"),
            insertable=false, updatable = false)
    private Institution institution;
}
