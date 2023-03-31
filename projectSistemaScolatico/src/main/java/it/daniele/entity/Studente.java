package it.daniele.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "studenti")
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "email", nullable = true)
    private String email;

    @OneToMany(mappedBy = "studente")
    private Set<Iscrizione> iscrizioni;

    public Studente() {
    }

    public Studente(String nome, String cognome, LocalDate dataDiNascita, String indirizzo, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.email = email;
    }

    // Getter e Setter

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Iscrizione> getIscrizioni() {
        return iscrizioni;
    }
    public void setIscrizioni(Set<Iscrizione> iscrizioni) {
        this.iscrizioni = iscrizioni;
    }
}