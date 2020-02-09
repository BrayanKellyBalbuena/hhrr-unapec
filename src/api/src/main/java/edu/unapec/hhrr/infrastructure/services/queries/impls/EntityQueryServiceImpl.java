package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;

import edu.unapec.hhrr.infrastructure.repositories.queries.EntityQueryRepository;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;


public class EntityQueryServiceImpl<TEntity extends AuditableEntity, ID>
        implements EntityQueryService<TEntity, ID> {

    private EntityQueryRepository<TEntity, ID> repository;

   public EntityQueryServiceImpl(EntityQueryRepository<TEntity, ID> repository) {
       this.repository = repository;
   }

    @Override
    public Optional<TEntity> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<TEntity> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<TEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
