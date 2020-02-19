package edu.unapec.hhrr.infrastructure.services.commands.impls;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.exceptions.ResourceNotFoundException;
import edu.unapec.hhrr.infrastructure.repositories.commands.EntityCommandRepository;
import edu.unapec.hhrr.infrastructure.services.commands.EntityCommandService;

import java.io.Serializable;

public abstract class EntityCommandServiceImpl<TEntity extends AuditableEntity, ID extends Serializable>
        implements EntityCommandService<TEntity, ID> {

    private static final  String RESOURCE_NOT_FOUND = "RESOURCE_NOT_FOUND";
    private static final  String ENTITY_NULL_MESSAGE = " is null";
    private EntityCommandRepository<TEntity, ID> repository;

    public EntityCommandServiceImpl(EntityCommandRepository<TEntity, ID> repository) {
        this.repository = repository;
    }
    @Override
    public void save(TEntity entity)
    {
        try {
            if( entity != null) {
                entity.setActive(true);
                repository.save(entity);
            } else {
                throw new NullPointerException(entity.getClass().getSimpleName() + ENTITY_NULL_MESSAGE);
            }
        } catch (Exception ex) {
            var r = 0;
        }


    }

    public void saveAll(Iterable<TEntity> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void deleteById(ID id) {
        if(repository.existsById(id))
            repository.deleteById(id);
        else throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
    }

    @Override
    public void delete(TEntity entity) {
        if(repository.existsById((ID) entity.getId())) {
            entity.setActive(false);
            repository.save(entity);
        }
        else throw new ResourceNotFoundException(RESOURCE_NOT_FOUND);
    }

    public void delete(Iterable<TEntity> entities) {
        entities.forEach(entity -> entity.setActive(false));
        repository.saveAll(entities);
    }

    @Override
    public void update(TEntity entity) {
        this.save(entity);
    }
}
