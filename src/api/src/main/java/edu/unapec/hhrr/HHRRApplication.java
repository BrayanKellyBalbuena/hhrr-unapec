package edu.unapec.hhrr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HHRRApplication {

	public static void main(String[] args) {
		SpringApplication.run(HHRRApplication.class, args);
	}

}
