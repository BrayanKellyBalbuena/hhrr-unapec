package edu.unapec.hhrr.configurations;

import edu.unapec.hhrr.core.entities.Job;
import edu.unapec.hhrr.core.entities.Skill;
import edu.unapec.hhrr.infrastructure.dtos.queries.job.JobQueryDto;
import edu.unapec.hhrr.infrastructure.dtos.queries.skill.SkillWithIDAndNameQueryDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public  class ModelMapperConfiguration {

    @Bean()
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ModelMapper modelMapper() {
        var mapper = new ModelMapper();

    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.typeMap(Job.class, JobQueryDto.class)
                .addMapping(src -> src.getRiskLevel().getName(), JobQueryDto::setRiskLevel);

        return mapper;
    }

}
