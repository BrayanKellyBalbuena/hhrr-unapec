package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.core.entities.Role;
import edu.unapec.hhrr.core.entities.User;
import edu.unapec.hhrr.core.enums.ERole;
import edu.unapec.hhrr.infrastructure.dtos.commands.candidate.CandidateCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.candidate.CandidateUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.exceptions.UserExistException;
import edu.unapec.hhrr.infrastructure.repositories.RoleRepository;
import edu.unapec.hhrr.infrastructure.repositories.UserRepository;
import edu.unapec.hhrr.infrastructure.security.jwt.JwtUtils;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsServiceImpl;
import edu.unapec.hhrr.infrastructure.services.commands.CandidateCommandService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/candidates")
@Api(tags = "Candidates")
public class CandidateCommandController  extends EntityCommandController<Candidate, Long, CandidateCreateCommandDto,
        CandidateUpdateCommandDto> {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    public CandidateCommandController(@Autowired CandidateCommandService commandService, @Autowired ModelMapper mapper) {
        super(commandService, Candidate.class, CandidateCreateCommandDto.class,
                CandidateUpdateCommandDto.class, mapper);
    }

    @Override
    public void create(@Valid @RequestBody CandidateCreateCommandDto candidateCreateCommandDto) {

        super.create(candidateCreateCommandDto);

        if (userRepository.existsByUsername(candidateCreateCommandDto.getUserName())) {
           throw  new UserExistException("Error userName is already in use!");
        }

        if (userRepository.existsByEmail(candidateCreateCommandDto.getEmail())) {
            throw  new UserExistException("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(candidateCreateCommandDto.getUserName(),
                candidateCreateCommandDto.getEmail(),
                encoder.encode(candidateCreateCommandDto.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

        var cantidate = mapper.map(candidateCreateCommandDto, Candidate.class);
        cantidate.setUserId(user.getId());
        commandService.save(cantidate);

    }
}
