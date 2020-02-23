package edu.unapec.hhrr.controllers.commands;

import edu.unapec.hhrr.core.entities.*;
import edu.unapec.hhrr.core.enums.ERole;
import edu.unapec.hhrr.infrastructure.dtos.abstracts.CatalogWithIdAndNameQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.candidate.CandidateCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.candidate.CandidateUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageCreateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.commands.language.LanguageUpdateCommandDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillQueryDto;
import edu.unapec.hhrr.infrastructure.exceptions.UserExistException;
import edu.unapec.hhrr.infrastructure.repositories.RoleRepository;
import edu.unapec.hhrr.infrastructure.repositories.UserRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.CandidateQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.LanguageQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.SkillQueryRepository;
import edu.unapec.hhrr.infrastructure.security.jwt.JwtUtils;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsImpl;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsServiceImpl;
import edu.unapec.hhrr.infrastructure.services.commands.CandidateCommandService;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.JobQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

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
    CandidateQueryService candidateQueryService;
    @Autowired
    SkillQueryRepository skillQueryRepository;

    @Autowired
    LanguageQueryRepository languageQueryRepository ;

    @Autowired
    JobQueryService jobQueryService;

    public CandidateCommandController(@Autowired CandidateCommandService commandService, @Autowired ModelMapper mapper,
                                      @Autowired CandidateQueryService candidateQueryService) {
        super(commandService, Candidate.class, CandidateCreateCommandDto.class,
                CandidateUpdateCommandDto.class, mapper);
        this.candidateQueryService = candidateQueryService;
    }

    @Override
    public void create(@Valid @RequestBody CandidateCreateCommandDto candidateCreateCommandDto) {

        if (userRepository.existsByUsername(candidateCreateCommandDto.getUserName())) {
           throw  new UserExistException("Error userName is already in use!");
        }

        if (userRepository.existsByEmail(candidateCreateCommandDto.getEmail())) {
            throw  new UserExistException("Error: Email is already in use!");
        }

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/add_skills")
    public void addSkills(@RequestBody List<Skill> skills) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var candidate = candidateQueryService.findByUserId( current.getId()).get();
       skills.forEach(e -> e.setActive(true));
        candidate.getSkills().addAll(skills);
        this.commandService.save(candidate);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get_skills")
    public Page<SkillQueryDto> getSkills(Pageable pageable) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var c = candidateQueryService.findByUserId( current.getId()).get();

       return this.skillQueryRepository
               .findByCandidatesId(c.getId(), pageable).map(e -> mapper.map(e, SkillQueryDto.class));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/not_assign_skills")
    public Page<SkillQueryDto> getNoAssingSkill(Pageable pageable) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var c = candidateQueryService.findByUserId( current.getId()).get();

        return  this.skillQueryRepository.
                findAllNotMatchCandidate(c.getId(), pageable).map(e -> mapper.map(e, SkillQueryDto.class));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/skills/{id}")
    public void deleteSkill(@PathVariable Long id) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var c = candidateQueryService.findByUserId( current.getId()).get();

        c.getSkills().removeIf(e -> e.getId() == id);
        this.commandService.save(c);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("languages/{id}")
    public void deleteLanguages(@PathVariable Long id) {

        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var candidate = candidateQueryService.findByUserId( current.getId()).get();

        candidate.getLanguages().removeIf(e -> e.getId() == id);
        this.commandService.save(candidate);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/add_languages")
    public void addLanguage(@RequestBody List<LanguageUpdateCommandDto> languagesDto) {
        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var candidate = candidateQueryService.findByUserId( current.getId()).get();
        var languages = languagesDto.stream().map(l -> mapper.map(l, Language.class)).collect(toSet());

        languages.forEach(e -> e.setActive(true));
        candidate.getLanguages().addAll(languages);
        this.commandService.save(candidate);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/jobs/{id}")
    public void applyJob(@PathVariable Long id) {
        var job = jobQueryService.findById(id);

        if(job.isPresent()) {
            var currentUser = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            var candidate = candidateQueryService.findByUserId(currentUser.getId()).get();

            candidate.getJobs().add(job.get());
            commandService.save(candidate);
        }
    }
}
