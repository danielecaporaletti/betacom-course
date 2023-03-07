package it.betacom.esempio.macchina;

import java.util.Calendar;

public class Car {
	
	private double fuel;
	private double consumption;
	private Calendar immatricolazione;

	
	public Car(int consumption) {
		fuel = 0;
		this.consumption = consumption;
		
		immatricolazione = Calendar.getInstance();
		immatricolazione.set(Calendar.YEAR, 2020);
		immatricolazione.set(Calendar.MONTH, Calendar.JANUARY);
		immatricolazione.set(Calendar.DAY_OF_MONTH, 1);
	}
		
	
	public void refueling(int newFuel) {
		fuel += newFuel;
	}
	
	public void usingFuel(int distance) {
		calculate(distance);
		if(fuel < 0) {
			System.out.println("Non c'è abbastanza carburante!!!");
			System.exit(0);
		}
	}
	
	private void calculate(int distance) {
		fuel = fuel - (distance / consumption);
	}
	
	public void utilizzabile(int annoCorrente) {
		
		int annoImmatricolazione = immatricolazione.get(Calendar.YEAR);
		
		if (annoCorrente - annoImmatricolazione > 10) {
			System.out.println("La macchina è troppo vecchia per viaggiare!!!");
			System.exit(0);
		}
	}
	
	@Override
	public String toString() {
		return String.format("La macchina ha %.2f di carburante.", fuel);
	}

}
