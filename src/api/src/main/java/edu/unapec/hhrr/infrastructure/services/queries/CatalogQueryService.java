package edu.unapec.hhrr.infrastructure.services.queries;

import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CatalogQueryService<TEntity extends Catalog, ID> extends EntityQueryService<TEntity, ID> {
    Page<TEntity> findByName(String name, Pageable pageable);
    Page<TEntity> findByDescription(String description, Pageable pageable);
}
