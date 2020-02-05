package edu.unapec.hhrr.infrastructure.services.impl;

import edu.unapec.hhrr.core.entites.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.services.EntityCommandService;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

public abstract class CommandServiceImpl<TEntity extends AuditableEntity, ID extends Serializable>
        implements EntityCommandService<TEntity, ID> {

    private PagingAndSortingRepository<TEntity, ID> repository;

    public CommandServiceImpl(PagingAndSortingRepository<TEntity, ID> repository) {
        this.repository = repository;
    }
    @Override
    public TEntity save(TEntity entity)
    {
         repository.save(entity);

         return entity;
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(TEntity entity) {
        repository.delete(entity);
    }

    @Override
    public void update(TEntity entity) {
        var result = repository.findById((ID) entity.getId()).get();
        repository.save(result);
    }
}
