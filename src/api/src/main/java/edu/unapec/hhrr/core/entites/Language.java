package edu.unapec.hhrr.core.entites;

import edu.unapec.hhrr.core.entites.abstracts.Catalog;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity()
@Where(clause = "is_active = true")
@Table(name="languages", indexes = {@Index( name = "idx_name", columnList = "name", unique = true)})
public class Language extends Catalog<Long> {

}
