package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public interface EntityQueryService<TEntity extends AuditableEntity, ID> {
    Optional<TEntity> findById(ID id);
    Iterable<TEntity> findAll(Sort sort);
    Page<TEntity> findAll(Pageable pageable);
    Page<TEntity> findAll(PageRequestDto pageRequest);
}
