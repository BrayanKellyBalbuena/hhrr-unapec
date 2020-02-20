package edu.unapec.hhrr.infrastructure.repositories;

import edu.unapec.hhrr.core.entities.Role;
import edu.unapec.hhrr.core.enums.ERole;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
