package org.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PruebaSoporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaSoporteApplication.class, args);
	}

}
