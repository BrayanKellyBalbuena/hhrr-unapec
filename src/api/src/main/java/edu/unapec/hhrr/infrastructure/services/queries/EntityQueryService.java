package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface EntityQueryService<TEntity extends AuditableEntity, ID> {
    Optional<TEntity> findById(ID id);
    Iterable<TEntity> findAll(Sort sort);
    Page<TEntity> findAll(Pageable pageable);
}
