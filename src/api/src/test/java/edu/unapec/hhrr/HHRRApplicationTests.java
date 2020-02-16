package edu.unapec.hhrr;

import edu.unapec.hhrr.core.entities.Language;
import edu.unapec.hhrr.infrastructure.services.commands.impls.LanguageCommandServiceImpl;
import edu.unapec.hhrr.infrastructure.services.queries.impls.LanguageQueryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HHRRApplicationTests {

	@Autowired
	LanguageQueryServiceImpl queryService;

	@Autowired
	LanguageCommandServiceImpl commandService;
	@Test
	void contextLoads() {
	}

	@Test
	public void shouldInsertLanguageEntity() {
		var language1 = new Language();
		language1.setName("English");
		language1.setDescription("US Language");

		var language2 = new Language();
		language2.setName("Spanish");
		language2.setDescription("Spain language");

		var languages = new ArrayList<Language>();
		languages.add(language1);
		languages.add(language2);

		commandService.saveAll(languages);
		var re = queryService.findAll(PageRequest.of(0, 20));

		assertThat(queryService.findAll(PageRequest.of(0, 20)).getContent().size())
				.isEqualTo(2);
	}
}
