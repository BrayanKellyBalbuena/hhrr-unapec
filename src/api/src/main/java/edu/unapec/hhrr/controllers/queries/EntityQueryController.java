package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.BaseQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.exceptions.ResourceNotFoundException;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class EntityQueryController<TEntity extends AuditableEntity , TDto extends BaseQueryDto, ID> {

    protected EntityQueryService<TEntity, ID> queryService;
    protected ModelMapper mapper;
    protected Class<TEntity> entityClass;
    protected Class<TDto> dtoClass;

    public EntityQueryController(EntityQueryService<TEntity, ID> queryService,Class<TEntity> entityClass,
                                 Class<TDto> dtoClass, ModelMapper mapper) {
        this.queryService = queryService;
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @GetMapping()
    public Page<TDto> get(PageRequestDto pageRequest) {
     var a =   queryService.findAll(pageRequest).map(entity -> mapper.map(entity, dtoClass));
        return a;
    }

    @GetMapping("/{id}")
    public TDto get(@PathVariable ID id) {
      return  queryService.findById(id).map( entity ->
           mapper.map(entity, dtoClass)).
              orElseThrow(() -> new ResourceNotFoundException(this.getClass().getSimpleName()
                .replace("Controller","")
                .replace("Query", "") + " not found with id " + id));
    }
}
