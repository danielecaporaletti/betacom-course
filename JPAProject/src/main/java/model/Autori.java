package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the autori database table.
 * 
 */
@Entity
@NamedQuery(name="Autori.findAll", query="SELECT a FROM Autori a")
public class Autori implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codiceAutore;

	@Temporal(TemporalType.DATE)
	private Date annoMorte;

	@Temporal(TemporalType.DATE)
	private Date annoNascita;

	private String nazione;

	private String nomeAutore;

	private String sesso;

	//bi-directional many-to-one association to Libri
	@OneToMany(mappedBy="autori")
	private Set<Libri> libris;

	public Autori() {
	}

	public int getCodiceAutore() {
		return this.codiceAutore;
	}

	public void setCodiceAutore(int codiceAutore) {
		this.codiceAutore = codiceAutore;
	}

	public Date getAnnoMorte() {
		return this.annoMorte;
	}

	public void setAnnoMorte(Date annoMorte) {
		this.annoMorte = annoMorte;
	}

	public Date getAnnoNascita() {
		return this.annoNascita;
	}

	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getNomeAutore() {
		return this.nomeAutore;
	}

	public void setNomeAutore(String nomeAutore) {
		this.nomeAutore = nomeAutore;
	}

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Set<Libri> getLibris() {
		return this.libris;
	}

	public void setLibris(Set<Libri> libris) {
		this.libris = libris;
	}

	public Libri addLibri(Libri libri) {
		getLibris().add(libri);
		libri.setAutori(this);

		return libri;
	}

	public Libri removeLibri(Libri libri) {
		getLibris().remove(libri);
		libri.setAutori(null);

		return libri;
	}

}