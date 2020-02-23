package edu.unapec.hhrr.infrastructure.repositories.queries;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.core.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LanguageQueryRepository extends EntityQueryRepository<Language, Long> {
   Page<Language> findByNameContains(String name, Pageable pageable);
   Page<Language> findByDescriptionContains(String description, Pageable pageable);

   @Query(
           value = "select l.* from languages l join candidates_languages c on l.id=c.language_id and c.candidate_id=?1 ORDER BY l.id",
           countQuery = "SELECT count(*) from languages l join candidates_languages c on l.id=c.language_id and c.candidate_id=?1",
           nativeQuery = true)
   Page<Language> findByCandidatesId(long userId, Pageable pageable);

   @Query(
           value = "select l.* from languages l where not exists (select language_id from candidates_languages c where language_id = l.id and c.candidate_id=?1)",
           countQuery = "SELECT count(*) from languages l where not exists (select language_id from candidates_languages where language_id = l.id and c.candidate_id=?1)",
           nativeQuery = true)
   Page<Language> findAllNotMatchCandidate(long userId, Pageable pageable);
}
