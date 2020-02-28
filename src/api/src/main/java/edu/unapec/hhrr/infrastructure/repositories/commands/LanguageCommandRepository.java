package edu.unapec.hhrr.infrastructure.repositories.commands;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface LanguageCommandRepository extends EntityCommandRepository<Language, Long> {

}
