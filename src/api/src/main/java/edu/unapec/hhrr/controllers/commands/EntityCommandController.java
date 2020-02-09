package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.EntityUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.exceptions.ResourceNotFoundException;
import edu.unapec.hhrr.infrastructure.services.commands.EntityCommandService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityCommandController<TEntity extends AuditableEntity, ID, TCreateCommandDto,
        TUpdateCommandDto extends EntityUpdateCommandDto> {
    protected final Class<TCreateCommandDto> createCommandDtoClass;
    protected final Class<TUpdateCommandDto> updateCommandDtoClass;
    protected final ModelMapper mapper;
    protected Class<TEntity> entityClass;
    protected EntityCommandService<TEntity, ID> commandService;

    public EntityCommandController(EntityCommandService<TEntity, ID> commandService, Class<TEntity> entityClass,
                                   Class<TCreateCommandDto> createCommandDtoClass,
                                   Class<TUpdateCommandDto> updateCommandDtoClass,
                                   ModelMapper mapper) {
        this.commandService = commandService;
        this.entityClass = entityClass;
        this.createCommandDtoClass = createCommandDtoClass;
        this.updateCommandDtoClass = updateCommandDtoClass;
        this.mapper = mapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody TCreateCommandDto createCommandDto) {
            commandService.save(mapper.map(createCommandDto, entityClass));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable ID id, @Valid @RequestBody TUpdateCommandDto updateCommandDto) {
        if(id ==  updateCommandDto.getId())
            commandService.update(mapper.map(updateCommandDto, entityClass));
        else throw new ResourceNotFoundException("not valid");

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ID id) {
         commandService.deleteById(id);
    }

    @DeleteMapping()
    public void delete(@Valid @RequestBody HashSet<TUpdateCommandDto> updateCommandDtos) {
       var entities =  updateCommandDtos
               .stream()
               .map(updateCommandDto -> mapper.map(updateCommandDto, entityClass))
               .collect(Collectors.toSet());

        commandService.delete(entities);
    }
}

