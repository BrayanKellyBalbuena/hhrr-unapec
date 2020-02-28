package edu.unapec.hhrr.controllers.queries;


import edu.unapec.hhrr.core.entities.abstracts.Catalog;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.institution.InstitutionQueryDto;
import edu.unapec.hhrr.infrastructure.enums.CatalogSeachField;
import edu.unapec.hhrr.infrastructure.services.queries.CatalogQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.EntityQueryService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "*", maxAge = 3600)
public abstract class CatalogQueryController<TEntity extends Catalog, TDto extends CatalogQueryDto, ID>
        extends EntityQueryController<TEntity, TDto, ID> {

    CatalogQueryService<TEntity, ID> catalogQueryService;

    public CatalogQueryController(CatalogQueryService<TEntity, ID> queryService, Class<TEntity> entityClass,
                                  Class<TDto> dtoClass, ModelMapper mapper) {
        super(queryService, entityClass, dtoClass, mapper);
        this.catalogQueryService = queryService;
    }


    @GetMapping("/searchBy")
    public Page<TDto> seachBy(CatalogSeachField searchBy, String seachCriteria,
                                             PageRequestDto pageRequest) {

        if(searchBy == CatalogSeachField.NAME)
            return this.catalogQueryService.findByName(seachCriteria,
                    PageRequest.of(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(), Sort.by(pageRequest.getSortDirection(),
                            "name") ))
                    .map(e -> mapper.map(e, dtoClass));
        else if (searchBy == CatalogSeachField.DESCRIPTION) {
            return this.catalogQueryService.findByDescription(seachCriteria,
                    PageRequest.of(pageRequest.getPageNumber() - 1, pageRequest.getPageSize(),
                            Sort.by(pageRequest.getSortDirection() , "description") ))
                    .map(e -> mapper.map(e, dtoClass));
        } else  {
            throw new IllegalArgumentException(searchBy.name());
        }
    }
}
