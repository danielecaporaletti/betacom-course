package it.betacom.model.autore;

public class Autore {
	private int codiceAutore;
	private String nomeAutore;
	private String annoNascita;
	private String annoMorte;
	private String sesso;
	private String nazione;
	
	public Autore(int codiceAutore, String nomeAutore, String annoNascita, String annoMorte, String sesso, String nazione) {
		this.codiceAutore = codiceAutore;
		this.nomeAutore = nomeAutore;
		this.annoNascita = annoNascita;
		this.annoMorte = annoMorte;
		this.sesso = sesso;
		this.nazione = nazione;
	}

	public int getCodiceAutore() {
		return codiceAutore;
	}

	public void setCodiceAutore(int codiceAutore) {
		this.codiceAutore = codiceAutore;
	}

	public String getNomeAutore() {
		return nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(String annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getAnnoMorte() {
		return annoMorte;
	}

	public void setAnnoMorte(String annoMorte) {
		this.annoMorte = annoMorte;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
}
