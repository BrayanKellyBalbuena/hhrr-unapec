package edu.unapec.hhrr.infrastructure.services.impl;

import edu.unapec.hhrr.core.entites.abstracts.AuditableEntity;

import edu.unapec.hhrr.infrastructure.services.EntityQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;


public class EntityQueryServiceImpl<TEntity extends AuditableEntity, ID>
        implements EntityQueryService<TEntity, ID> {

    private PagingAndSortingRepository<TEntity, ID> repository;

   public EntityQueryServiceImpl(PagingAndSortingRepository<TEntity, ID> repository) {
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
