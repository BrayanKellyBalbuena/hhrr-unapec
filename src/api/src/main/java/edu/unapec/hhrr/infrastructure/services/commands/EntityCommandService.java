package edu.unapec.hhrr.infrastructure.services.commands;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;

public interface EntityCommandService<TEntity extends AuditableEntity, ID> {
    void save(TEntity entity);
    void saveAll(Iterable<TEntity> entities);
    void deleteById(ID id);
    void delete(TEntity entity);
    void delete(Iterable<TEntity> entities);
    void update(TEntity entity);
}
