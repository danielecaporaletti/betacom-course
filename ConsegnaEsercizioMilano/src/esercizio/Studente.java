package esercizio;

import java.time.LocalDate;

public class Studente {

	private String nome;
	private String matricola;
	private LocalDate dataDiNascita;

	public Studente(String nome, String matricola, LocalDate nascitaStud) {
		this.nome = nome;
		this.matricola = matricola;
		this.dataDiNascita = nascitaStud;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

}
