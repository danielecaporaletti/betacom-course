package it.betacom.EsempioSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.betacom.model.Persona;

@Configuration
public class AppConfig {

	@Bean(name="utente")
	Persona persona() {
		return new Persona();
	}
	
}
