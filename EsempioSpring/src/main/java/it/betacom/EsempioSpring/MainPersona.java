package it.betacom.EsempioSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import it.betacom.model.Persona;

public class MainPersona {

	@Bean(name="utente")
	Persona persona() {
		return new Persona();
	}
	
	public static void main(String[] args) {
	
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MainPersona.class);
		Persona p = context.getBean(Persona.class);
		
		p.setNome("Giuseppe");
		p.setCognome("Verdi");
		System.out.println(p);
		Persona p1 = context.getBean("utente",Persona.class);
		p1.setNome("Anna");
		p1.setCognome("Neri");
		System.out.println(p1);
		
		
		
		
		
		  ((ConfigurableApplicationContext) context).close();
		
	}

}
