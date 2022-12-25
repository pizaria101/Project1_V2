package dev.schulte.Project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"dev.schulte.configs"})
@ComponentScan(basePackages = {"dev.schulte"})
@EntityScan(basePackages = {"dev.schulte.entities"})
@EnableJpaRepositories(basePackages = {"dev.schulte.repos"})
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
