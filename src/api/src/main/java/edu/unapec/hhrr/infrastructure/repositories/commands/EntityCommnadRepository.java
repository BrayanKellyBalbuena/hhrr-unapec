package edu.unapec.hhrr.infrastructure.repositories.commands;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public interface EntityCommnadRepository<TEntity extends AuditableEntity, ID extends Serializable>
        extends PagingAndSortingRepository<TEntity, ID> {
}
