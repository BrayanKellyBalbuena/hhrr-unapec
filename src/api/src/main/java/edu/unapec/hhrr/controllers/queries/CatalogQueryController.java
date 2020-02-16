package edu.unapec.hhrr.controllers.queries;


import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class CatalogQueryController<TEntity extends Catalog, TDto extends CatalogQueryDto, ID>
        extends EntityQueryController<TEntity, TDto, ID> {

    public CatalogQueryController(EntityQueryService<TEntity, ID> queryService, Class<TEntity> entityClass,
                                  Class<TDto> dtoClass, ModelMapper mapper) {
        super(queryService, entityClass, dtoClass, mapper);
    }

    @GetMapping("/searchBy")
    public abstract Page<TDto> seachBy(@PathVariable CatalogSeachField searchBy, String seachCriteria,
                                       PageRequestDto pageRequest);
}
