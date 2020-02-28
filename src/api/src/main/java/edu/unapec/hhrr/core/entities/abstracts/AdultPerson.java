package edu.unapec.hhrr.core.entities.abstracts;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class AdultPerson<ID extends Serializable> extends  Person<ID>{
    @Column(name = "identity_card", nullable = false, length = 11 )
    private String identityCard;

}
