package edu.unapec.hhrr.infrastructure.repositories.commands;

import edu.unapec.hhrr.core.entities.Job;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JobCommandRepository extends EntityCommnadRepository<Job, Long> {
}
