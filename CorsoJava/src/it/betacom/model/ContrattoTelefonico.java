package it.betacom.model;

import java.util.ArrayList;

public class ContrattoTelefonico {
	
	private String numTel; 
	private String name;
	public final double COSTO_AL_SECONDO = 0.01; 
	private ArrayList<Chiamata> chiamate = new ArrayList<Chiamata>();
	
	public ContrattoTelefonico(String name, String numTel) {
		this.name = name;
		this.numTel = numTel;
	}
	
	public void chiamata(int tempoChiamata) {
		
		chiamate.add(new Chiamata(tempoChiamata, (double)tempoChiamata * COSTO_AL_SECONDO));
		
	}
	
	public void chiamtaCostiAggintivi(int tempoChiamata, double costiAggiuntivi) {
		
		chiamate.add(new Chiamata(tempoChiamata, ((double)tempoChiamata * COSTO_AL_SECONDO) + costiAggiuntivi));
		
	}
	
	public String getDatiUtente() {
		
		return "Nome: " + name + ", Numero: " + numTel;
		
	}
	
	public double getBolletta() {
		
		double tot = 0.0;
		
		for (Chiamata c : chiamate) {
			tot += c.getCosto();
		}
		
		return Math.round(tot*100.0)/100.0;
	}
	
	public String GetNumTel() {
		return numTel;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Chiamata> getChiamate() {
		return chiamate;
	}
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		
		for (Chiamata c : chiamate) {
			s.append("Chiamata del " + c.getData() + " che è durata " + c.getDurata() + " secondi, ed è costata " + c.getCosto() + "€\n");
		}
		
		return s.toString();
	}
	
	

}
