package it.betacom.model.libro;

public class Libro {
	
	private int codiceLibro;
	private String Autore;
	private String Genere;
	private String Editore;
	private String titolo;
	private int numPag;
	private int anno;
	
	public Libro(int codiceLibro, String Autore, String Genere, String Editore, String titolo, int numPag, int anno) {
		this.codiceLibro = codiceLibro;
		this.Autore = Autore;
		this.Genere = Genere;
		this.Editore = Editore;
		this.titolo = titolo;
		this.numPag = numPag;
		this.anno = anno;
	}

	public int getCodiceLibro() {
		return codiceLibro;
	}



	public String getAutore() {
		return Autore;
	}



	public String getGenere() {
		return Genere;
	}



	public String getEditore() {
		return Editore;
	}



	public String getTitolo() {
		return titolo;
	}



	public int getNumPag() {
		return numPag;
	}



	public int getAnno() {
		return anno;
	}
	
	public String toString() {
		return "Codice libro: " + codiceLibro + " | "
					+ "Titolo: " + titolo + " | "
					+ "Autore: " + Autore + " | "
					+ "Genere: " + Genere + " | "
					+ "Editore: " + Editore + " | "
					+ "Pagine: " + numPag + " | "
					+ "Anno: " + anno + "\n";
	}
	



}
