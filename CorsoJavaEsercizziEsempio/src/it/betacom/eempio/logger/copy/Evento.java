package it.betacom.eempio.logger.copy;

import java.util.Random;

public class Evento {
	private Livello livello;
	private String descrizione;
	
	public Evento(Livello livello){
		this.descrizione = RandomString.generator();
		this.livello = livello;
	}
	
	public Livello getLivello() {
		return livello;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
}
