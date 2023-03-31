package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the generi database table.
 * 
 */
@Entity
@NamedQuery(name="Generi.findAll", query="SELECT g FROM Generi g")
public class Generi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codiceGenere;

	private String descrizione;

	//bi-directional many-to-one association to Libri
	@OneToMany(mappedBy="generi")
	private Set<Libri> libris;

	public Generi() {
	}

	public int getCodiceGenere() {
		return this.codiceGenere;
	}

	public void setCodiceGenere(int codiceGenere) {
		this.codiceGenere = codiceGenere;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Libri> getLibris() {
		return this.libris;
	}

	public void setLibris(Set<Libri> libris) {
		this.libris = libris;
	}

	public Libri addLibri(Libri libri) {
		getLibris().add(libri);
		libri.setGeneri(this);

		return libri;
	}

	public Libri removeLibri(Libri libri) {
		getLibris().remove(libri);
		libri.setGeneri(null);

		return libri;
	}

}