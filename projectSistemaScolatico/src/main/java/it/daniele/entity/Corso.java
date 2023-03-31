package it.daniele.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "corsi")
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "crediti")
    private Integer crediti;

    @ManyToOne
    @JoinColumn(name = "insegnante_id")
    private Insegnante insegnante;

    @OneToMany(mappedBy = "corso")
    private Set<Iscrizione> iscrizioni;

    public Corso() {
    }

    public Corso(String titolo, String descrizione, Integer crediti, Insegnante insegnante) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.crediti = crediti;
        this.insegnante = insegnante;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getCrediti() {
		return crediti;
	}
	public void setCrediti(Integer crediti) {
		this.crediti = crediti;
	}
	public Insegnante getInsegnante() {
		return insegnante;
	}
	public void setInsegnante(Insegnante insegnante) {
		this.insegnante = insegnante;
	}
	public Set<Iscrizione> getIscrizioni() {
		return iscrizioni;
	}
	public void setIscrizioni(Set<Iscrizione> iscrizioni) {
		this.iscrizioni = iscrizioni;
	}
}