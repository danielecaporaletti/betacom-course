package it.betacom.dado;

import java.util.Random;

//	SCRIVERE UN PROGRAMMA CHE USI LA CLASSE RANDOM PER SMULARE IL LANCIO DI UN DADO,
//VISUALIZZANDO UN NUMERO CASUALE COMPRESO TRA 1 E 6 OGNI VOLTA CHE VIENE ESEGUITO

public class Lancio {
	
	private FacciaDado risultato;
	
	public Lancio() {
		
		//IL METODO nextInt DELLA CLASSE RANDOM RITORNA UN NUMERO COMPRESO TRA 0 E n
		//SE min = 1 E max = 6 ALLORA:
		//int value = random.nextInt(max) + min;
		Random random = new Random();
		int numero = random.nextInt(6) + 1;
		switch (numero) {
		case 1:
			risultato = FacciaDado.ONE;
			break;
		case 2:
			risultato = FacciaDado.TWO;
			break;
		case 3:
			risultato = FacciaDado.THREE;
			break;
		case 4:
			risultato = FacciaDado.FOUR;
			break;
		case 5:
			risultato = FacciaDado.FIVE;
			break;
		case 6:
			risultato = FacciaDado.SIX;
			break;
		default: System.out.println("Qualcosa non quadra");
			break;
		}
	}
	
	public FacciaDado getRisultato() {
		return risultato;
	}

}

