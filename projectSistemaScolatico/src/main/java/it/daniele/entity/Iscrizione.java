package it.daniele.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "iscrizioni")
public class Iscrizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studente_id")
    private Studente studente;

    @ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;

    @Column(name = "data_iscrizione")
    private LocalDate dataIscrizione;

    @Column(name = "voto")
    private Integer voto;

    public Iscrizione() {
    }

    public Iscrizione(Studente studente, Corso corso, LocalDate dataIscrizione, Integer voto) {
        this.studente = studente;
        this.corso = corso;
        this.dataIscrizione = dataIscrizione;
        this.voto = voto;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public Corso getCorso() {
		return corso;
	}
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}
	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}
	public Integer getVoto() {
		return voto;
	}
	public void setVoto(Integer voto) {
		this.voto = voto;
	}
}