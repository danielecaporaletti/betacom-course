package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the editori database table.
 * 
 */
@Entity
@NamedQuery(name="Editori.findAll", query="SELECT e FROM Editori e")
public class Editori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codiceEditore;

	private String nome;

	//bi-directional many-to-one association to Libri
	@OneToMany(mappedBy="editori")
	private Set<Libri> libris;

	public Editori() {
	}

	public int getCodiceEditore() {
		return this.codiceEditore;
	}

	public void setCodiceEditore(int codiceEditore) {
		this.codiceEditore = codiceEditore;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Libri> getLibris() {
		return this.libris;
	}

	public void setLibris(Set<Libri> libris) {
		this.libris = libris;
	}

	public Libri addLibri(Libri libri) {
		getLibris().add(libri);
		libri.setEditori(this);

		return libri;
	}

	public Libri removeLibri(Libri libri) {
		getLibris().remove(libri);
		libri.setEditori(null);

		return libri;
	}

}