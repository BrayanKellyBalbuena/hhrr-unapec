package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity()
@Where(clause = "is_active = true")
@Table(name="languages", indexes = {@Index(name = "idx_language_isActive", columnList = "is_active"),
        @Index( name = "uidx_language_name", columnList = "name", unique = true)})
@Getter
@Setter

public class Language extends Catalog<Long> {
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "languages")
    private Set<Candidate> candidates = new HashSet<>();

    public String toString() {
        var stringBuilder = new  StringBuilder();
        stringBuilder.append("Id:" + this.getId());
        stringBuilder.append("name:" + this.getName());

        return stringBuilder.toString();
    }
}
