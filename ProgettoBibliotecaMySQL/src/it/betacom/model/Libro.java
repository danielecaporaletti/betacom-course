package it.betacom.model;

public class Libro {
	
	private String titolo;
	private String autore;
	private String genere;
	private String editore;
	private int numPag;
	private int anno;
	
	public Libro(String titolo, String autore, String genere, String editore, int numPag, int anno) {
		this.titolo = titolo;
		this.autore = autore;
		this.genere = genere;
		this.editore = editore;
		this.numPag = numPag;
		this.anno = anno;
	}
	
	public String toString() {
		return "Il libro ha le seguenti caratteristiche:<br>"
				+ "<font color='red'>Titolo:</font> " + this.titolo + "<br>"
				+ "<font color='red'>Autore:</font> " + this.autore + "<br>"
				+ "<font color='red'>Genere:</font> " + this.genere + "<br>"
				+ "<font color='red'>Editore:</font> " + this.editore + "<br>"
				+ "<font color='red'>Numero di pagine:</font> " + this.numPag + "<br>"
				+ "<font color='red'>Anno di pubblicazione:</font> " + this.anno + "<br><br>";
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}

	public String getEditore() {
		return editore;
	}

	public int getNumPag() {
		return numPag;
	}

	public int getAnno() {
		return anno;
	}

}
