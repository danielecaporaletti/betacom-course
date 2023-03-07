package it.betacom.esempio.conto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	static Scanner in = new Scanner(System.in);
	
	//INSERISCI UN NUMERO DA a A b (INCLUSI)
	public static int inserisci(int a, int b) {
		
		boolean inputValid = false;
		int numero = 0;
		
		while (!inputValid) {
			try {
				numero = in.nextInt();
				if(numero >= a && numero <= b) inputValid = true;
				else System.out.println("Inserisci " + a + " o " + b + ": ");
				
			} catch (InputMismatchException e) {
			      System.out.println("Errore: hai inserito un valore non valido, riprova!");
			      in.nextLine();
			      numero = inserisci(a, b); 
			      inputValid = true;
			}
			
		}
		in.close();
		return numero;
	}
	

}
