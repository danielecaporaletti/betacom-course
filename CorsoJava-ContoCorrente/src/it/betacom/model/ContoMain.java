package it.betacom.model;

import java.time.LocalDate;

import it.betacom.util.FileWriters;

public class ContoMain {
	
	public static void main(String[] args) {
		
		LocalDate dataCreazione = LocalDate.of(2021, 1, 1);
		
		
		ContoCorrente contoCorrente = new ContoCorrente("Mario", dataCreazione, 1000);
		ContoDeposito contoDeposito = new ContoDeposito("Luigi", dataCreazione, 1000);
		
		
		System.out.println(contoCorrente.toString(dataCreazione));
		System.out.println(contoDeposito.toString(dataCreazione));
		

		
		System.out.println("------------------------------------------------------------------");
		/*PRIMO CONTROLLO*/
		LocalDate oggi1 = LocalDate.of(2021, 12, 31);
		System.out.println("Oggi è il " + oggi1.toString() + " aggiorniamo il conto!\n");
		
		
		contoCorrente.aggiornaInteresse(oggi1);
		System.out.println(contoCorrente.toString(oggi1));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoCorrente" + oggi1.getYear() + ".pdf", contoCorrente.toString(oggi1));
		contoCorrente.cleanOperazioni();
		System.out.println();
		
		contoDeposito.aggiornaInteresse(oggi1);
		System.out.println(contoDeposito.toString(oggi1));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoDeposito" + oggi1.getYear() + ".pdf", contoCorrente.toString(oggi1));
		contoDeposito.cleanOperazioni();
		
		
		System.out.println("------------------------------------------------------------------");
		/*PRIMO PRELIEVO*/
		LocalDate oggi15 = LocalDate.of(2022, 7, 1);
		System.out.println("Oggi è il " + oggi15.toString() + ", facciamo un prelievo di 900€\n");
		contoCorrente.preleva(900, oggi15);
		System.out.println();
		
		System.out.println("------------------------------------------------------------------");
		/*SECONDO CONTROLLO*/
		LocalDate oggi2 = LocalDate.of(2022, 12, 31);
		System.out.println("Oggi è il " + oggi2.toString() + " aggiorniamo il conto!\n");
		
		
		contoCorrente.aggiornaInteresse(oggi2);
		System.out.println(contoCorrente.toString(oggi2));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoCorrente" + oggi2.getYear() + ".pdf", contoCorrente.toString(oggi2));
		contoCorrente.cleanOperazioni();
		System.out.println();
		
		contoDeposito.aggiornaInteresse(oggi2);
		System.out.println(contoDeposito.toString(oggi2));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoDeposito" + oggi2.getYear() + ".pdf", contoCorrente.toString(oggi2));
		contoDeposito.cleanOperazioni();
		
		
		System.out.println("------------------------------------------------------------------");
		/*TERZO CONTROLLO*/
		LocalDate oggi = LocalDate.now();
		System.out.println("Oggi è il " + oggi.toString() + " aggiorniamo il conto!\n");
		
		
		contoCorrente.aggiornaInteresse(oggi);
		System.out.println(contoCorrente.toString(oggi));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoCorrente" + oggi.getYear() + ".pdf", contoCorrente.toString(oggi));
		contoCorrente.cleanOperazioni();
		System.out.println();
		
		contoDeposito.aggiornaInteresse(oggi);
		System.out.println(contoDeposito.toString(oggi));
		FileWriters.scriviPDF(contoCorrente, "EstrattoContoDeposito" + oggi.getYear() + ".pdf", contoCorrente.toString(oggi));
		contoDeposito.cleanOperazioni();
		
		
		
		
		
		
	}
	
	

}
