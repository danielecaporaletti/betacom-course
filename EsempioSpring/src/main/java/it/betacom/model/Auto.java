package it.betacom.model;

public class Auto {
	
	private Motore motore;
	
	public Auto(Motore motore) {
		this.motore= motore;
		System.out.print("Auto costruita");
	}
	
	public void avviaAuto() {
		motore.accendi();
	}
}
