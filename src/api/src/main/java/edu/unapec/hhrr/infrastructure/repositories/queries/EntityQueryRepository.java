package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntityQueryRepository<TEntity extends AuditableEntity, ID>
        extends PagingAndSortingRepository<TEntity, ID> {
}
