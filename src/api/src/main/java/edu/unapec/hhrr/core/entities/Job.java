package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jobs", indexes = {@Index(name = "idx_jobs_isActive", columnList = "is_active"),
        @Index( name = "uidx_jobs_name", columnList = "name"),
        @Index( name = "idx_jobs_risklevel", columnList = "risk_level_id")})
@Where(clause = "is_active = true")
@Getter
@Setter
public class Job extends Catalog<Long> {

    @Column(name = "risk_level_id")
    private Long riskLevelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "risk_level_id", foreignKey = @ForeignKey(name = "fk_jobs_risklevel"),
            insertable=false, updatable = false)
    private RiskLevel riskLevel;

    @Column(name = "minimun_salary", columnDefinition="Decimal(10,2)",nullable = false, precision = 10, scale = 2)
    private Double mininumSalary;
    @Column(name = "maximun_salary", columnDefinition="Decimal(10,2)", nullable = false, precision = 10, scale = 2)
    private Double maximunSalary;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "jobs")
    private Set<Candidate> candidates = new HashSet<>();

    public Long getNumberOfCandidatesApply() {

     return  new Long(candidates.size());

    }
}
