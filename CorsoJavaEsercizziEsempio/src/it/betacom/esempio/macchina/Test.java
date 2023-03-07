package it.betacom.esempio.macchina;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		Car Ford = new Car(24);
		
		System.out.println("CREATO OGGETTO FORD : " + Ford.toString() + "\n");
		Ford.utilizzabile(year);
		
		System.out.println("\nFacciamo un pò di benzina!");
		Ford.utilizzabile(year);
		Ford.refueling(10);
		System.out.println("RIFORNIMENTO DI CARBURANTE : " + Ford.toString() + "\n");
		
		System.out.println("\nAndiamo in viaggio!");
		Ford.utilizzabile(year);
		Ford.usingFuel(100);
		System.out.println(Ford.toString());
		
		


	}

}
