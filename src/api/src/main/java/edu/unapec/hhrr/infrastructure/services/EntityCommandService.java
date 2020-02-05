package edu.unapec.hhrr.infrastructure.services;

import edu.unapec.hhrr.core.entites.abstracts.AuditableEntity;

public interface EntityCommandService<TEntity extends AuditableEntity, ID> {
    TEntity save(TEntity entity);
    void deleteById(ID id);
    void delete(TEntity entity);
    void update(TEntity entity);
}
