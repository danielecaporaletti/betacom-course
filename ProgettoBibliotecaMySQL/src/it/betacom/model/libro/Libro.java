package it.betacom.model.libro;

public class Libro {
	
	private int codiceLibro;
	private int codiceAutore;
	private int codiceGenere;
	private int codiceEditore;
	private String titolo;
	private int numPag;
	private int anno;
	
	public Libro(int codiceLibro, int codiceAutore, int codiceGenere, int codiceEditore, String titolo, int numPag, int anno) {
		this.codiceLibro = codiceLibro;
		this.codiceAutore = codiceAutore;
		this.codiceGenere = codiceGenere;
		this.codiceEditore = codiceEditore;
		this.titolo = titolo;
		this.numPag = numPag;
		this.anno = anno;
	}

	public int getCodiceLibro() {
		return codiceLibro;
	}

	public void setCodiceLibro(int codiceLibro) {
		this.codiceLibro = codiceLibro;
	}

	public int getCodiceAutore() {
		return codiceAutore;
	}

	public void setCodiceAutore(int codiceAutore) {
		this.codiceAutore = codiceAutore;
	}

	public int getCodiceGenere() {
		return codiceGenere;
	}

	public void setCodiceGenere(int codiceGenere) {
		this.codiceGenere = codiceGenere;
	}

	public int getCodiceEditore() {
		return codiceEditore;
	}

	public void setCodiceEditore(int codiceEditore) {
		this.codiceEditore = codiceEditore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

}
