package edu.unapec.hhrr.controllers.queries;

import edu.unapec.hhrr.core.entities.Candidate;
import edu.unapec.hhrr.infrastructure.dtos.queries.candidate.CandidateQueryDto;
import edu.unapec.hhrr.infrastructure.services.queries.CandidateQueryService;
import edu.unapec.hhrr.infrastructure.services.queries.CatalogQueryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/api/candidates")
@Api(tags = "Candidates")
public class CandidateQueryController extends EntityQueryController<Candidate, CandidateQueryDto, Long>  {
    public CandidateQueryController(CandidateQueryService queryService, ModelMapper mapper) {
        super(queryService, Candidate.class, CandidateQueryDto.class, mapper);

    }
}
