package it.betacom.EsempioSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.betacom.model.Persona;

public class App2 {

	public static void main(String[] args) {
		
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Persona p = context.getBean(Persona.class);
		p.setNome("Fabio");
		p.setCognome("Rossi");
		System.out.println(p);

	}

}
