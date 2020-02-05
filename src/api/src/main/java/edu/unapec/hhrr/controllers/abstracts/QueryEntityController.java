package edu.unapec.hhrr.controllers.abstracts;

import edu.unapec.hhrr.core.entites.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.services.EntityQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryEntityController<TEntity extends AuditableEntity, TDto, ID> {

    private EntityQueryService<TEntity, ID> service;

    public QueryEntityController(EntityQueryService<TEntity, ID> service) {
        this.service = service;
    }

    @GetMapping()
    public Page<TEntity> getQuestions(Pageable pageable) {
        return service.findAll(pageable);
    }

}
