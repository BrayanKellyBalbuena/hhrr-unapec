package edu.unapec.hhrr.infrastructure.services.queries.impls;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.dtos.queries.PageRequestDto;
import edu.unapec.hhrr.infrastructure.repositories.queries.CandidateQueryRepository;
import edu.unapec.hhrr.infrastructure.repositories.queries.EntityQueryRepository;
import edu.unapec.hhrr.infrastructure.security.services.UserDetailsImpl;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.utils.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateQueryServiceImpl extends EntityQueryServiceImpl<Candidate, Long> implements CandidateQueryService {

    private CandidateQueryRepository  candidateQueryRepository;

    public CandidateQueryServiceImpl(CandidateQueryRepository repository) {
        super(repository);
        this.candidateQueryRepository = repository;
    }

    @Override
    public Page<Candidate> findByFirstNameContains(String name, Pageable pageable) {
       return this.candidateQueryRepository.findByFirstNameContains(name,  pageable);
    }

    @Override
    public Page<Candidate> findByLastNameContains(String lastName, Pageable pageable) {
        return this.candidateQueryRepository.findByLastNameContains(lastName, pageable);
    }

    @Override
    public Page<Candidate> findByIdentityCardContains(String identityCard, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Candidate> findByAgeEquals(short age, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Candidate> findAllBySkillsEquals(Long skill, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Candidate> findByUserId(Long id) {
        return candidateQueryRepository.findByUserId(id);
    }

    @Override
    public Candidate getCurrentCandidate() {
        var current = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return candidateQueryRepository.findByUserId(current.getId()).get();
    }

    @Override
    public Page<Candidate> findAllCandidatesByApplyJobId(Long jobId, PageRequestDto pageRequestDto) {
        return candidateQueryRepository.findAllCandidatesByApplyJobId(jobId, Converter.PageRequestDtoToPageable(pageRequestDto));
    }
}
