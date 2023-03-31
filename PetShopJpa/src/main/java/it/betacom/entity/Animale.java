package it.betacom.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animale")
public class Animale {
	
	@Id
	private Long matricola;
	private String nome;
	private LocalDate dataAcquisto;
	private double prezzo;
	
	@ManyToOne
	@JoinColumn(name = "tipo_animale_id")
	TipoAnimale tipoAnimale;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	Cliente cliente;
	
	public Animale() {
	}
	
	public Animale(Long matricola, String nome, LocalDate dataAcquisto, double prezzo, TipoAnimale tipoAnimale, Cliente cliente) {
	    this.matricola = matricola;
	    this.nome = nome;
	    this.dataAcquisto = dataAcquisto;
	    this.prezzo = prezzo;
	    this.tipoAnimale = tipoAnimale;
	    this.cliente = cliente;
	}

	public Long getMatricola() {
		return matricola;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataAcquisto() {
		return dataAcquisto;
	}

	public void setDataAcquisto(LocalDate dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public TipoAnimale getTipoAnimale() {
		return tipoAnimale;
	}

	public void setTipoAnimale(TipoAnimale tipoAnimale) {
		this.tipoAnimale = tipoAnimale;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
