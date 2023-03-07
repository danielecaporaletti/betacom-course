package it.betacom.model;

import java.time.LocalDate;

public class Chiamata {
	
	private LocalDate data;
	private int durata;
	private double costo;
	
	public Chiamata(int durata, double costo) {
		data = LocalDate.now();
		this.durata = durata;
		this.costo = costo;
	}

	public double getCosto() {
		return  Math.round(costo * 100.0) / 100.0;
	}

	public int getDurata() {
		return durata;
	}

	public LocalDate getData() {
		return data;
	}
	
	
	
	
}
