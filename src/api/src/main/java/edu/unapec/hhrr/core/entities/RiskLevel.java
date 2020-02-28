package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "risk_level", indexes = {@Index(name = "idx_risklevel_isActive", columnList = "is_active"),
        @Index(name = "uidx_risklevel_name",columnList = "name", unique = true)})
@Where(clause = "is_active = true")
@Getter
@Setter
public class RiskLevel extends Catalog<Long> {

}
