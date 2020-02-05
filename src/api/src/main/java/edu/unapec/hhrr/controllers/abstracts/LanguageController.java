package edu.unapec.hhrr.controllers.abstracts;

import edu.unapec.hhrr.core.entites.Language;
import edu.unapec.hhrr.infrastructure.exceptions.ResourceNotFoundException;
import edu.unapec.hhrr.infrastructure.services.LanguageQueryService;
import edu.unapec.hhrr.infrastructure.services.LanguageCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languages")
public class LanguageController  {

    private LanguageQueryService service;
    private LanguageCommandService serviceCommand;

    public LanguageController(@Autowired LanguageQueryService service, @Autowired LanguageCommandService serviceCommand) {
        this.service = service;
        this.serviceCommand = serviceCommand;
    }

    @GetMapping()
    public Page<Language> get(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Language get(@PathVariable Long id) {
        var language = service.findById(id);

        if (language.isPresent()) return language.get();
        else throw new ResourceNotFoundException("Question not found with id " + id);
    }

    @PostMapping()
    public Language create(@Valid @RequestBody Language language) {
         serviceCommand.save(language);
        return language;
    }

    @PutMapping("/{id}")
    public Language update(@PathVariable Long id,
                                   @Valid @RequestBody Language request) {
        return service.findById(id)
                .map(question -> {
                    question.setName(request.getName());
                    var  entity = serviceCommand.save(question);
                     return entity;
                }).orElseThrow(() -> new ResourceNotFoundException("Languaje not found with id " + id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(question -> {
                    serviceCommand.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Languaje not found with id " + id));
    }
}
