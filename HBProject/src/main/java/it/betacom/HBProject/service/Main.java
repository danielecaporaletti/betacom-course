package it.betacom.HBProject.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.betacom.HBProject.entity.Song;



public class Main {

	public static void main(String[] args) {
	
		System.out.println("Hello");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Song song = new Song();
		song.setId(2);
		song.setSongName("Felicità");
		song.setArtist("Albano");
		
		session.beginTransaction();
		session.save(song);
		session.getTransaction().commit();
		session.close();
		factory.close();
	
		
		

	}

}
