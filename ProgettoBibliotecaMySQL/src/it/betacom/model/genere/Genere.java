package it.betacom.model.genere;

public class Genere {
	
	int codiceGenere;
	String descrizione;
	
	public Genere(int codiceGenere, String descrizione) {
		this.codiceGenere = codiceGenere;
		this.descrizione = descrizione;
	}

	public int getCodiceGenere() {
		return codiceGenere;
	}

	public void setCodiceGenere(int codiceGenere) {
		this.codiceGenere = codiceGenere;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
