package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the libri database table.
 * 
 */
@Entity
@NamedQuery(name="Libri.findAll", query="SELECT l FROM Libri l")
public class Libri implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codiceLibro;

	private int anno;

	private int numPag;

	private String titolo;

	//bi-directional many-to-one association to Autori
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codiceAutore")
	private Autori autori;

	//bi-directional many-to-one association to Editori
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codiceEditore")
	private Editori editori;

	//bi-directional many-to-one association to Generi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codiceGenere")
	private Generi generi;

	public Libri() {
	}

	public int getCodiceLibro() {
		return this.codiceLibro;
	}

	public void setCodiceLibro(int codiceLibro) {
		this.codiceLibro = codiceLibro;
	}

	public int getAnno() {
		return this.anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getNumPag() {
		return this.numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Autori getAutori() {
		return this.autori;
	}

	public void setAutori(Autori autori) {
		this.autori = autori;
	}

	public Editori getEditori() {
		return this.editori;
	}

	public void setEditori(Editori editori) {
		this.editori = editori;
	}

	public Generi getGeneri() {
		return this.generi;
	}

	public void setGeneri(Generi generi) {
		this.generi = generi;
	}

}