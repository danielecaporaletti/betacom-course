package it.betacom.service;

import java.time.LocalDate;

import it.betacom.model.Chiamata;
import it.betacom.model.ContrattoFisso;
import it.betacom.model.ContrattoMobile;
import it.betacom.model.ContrattoTelefonico;
import it.betacom.util.FileWriters;
import it.betacom.util.RandomNumber;

public class Main {
	
	public static String textBolletta(ContrattoTelefonico c, LocalDate currentDate) {
		return ("************************************************************************\n"
				+ "||Bolletta del: " + currentDate.toString() + "||\n"
				+ "||Nome utente: " + c.getName() + "|| Numero telefonate: " + c.getChiamate().size() + "||Costo totale: " + c.getBolletta() + "||\n"
				+ "||SPECIFICHE CHIAMATE||\n" 
				+ c.toString() + "************************************************************************\n");
	}
	
	public static String[] header() {
		
		return new String[] {"DataChiamata", "DurataChiamata", "CostoChiamata"};
		
	}
	
	public static String[][] data(ContrattoTelefonico c){
		
		String[][] tabellaChiamate = new String[c.getChiamate().size()][3];
		int i = 0;
		
		for (Chiamata chiamata : c.getChiamate()) {
		    tabellaChiamate[i][0] = chiamata.getData().toString();
		    tabellaChiamate[i][1] = "" + chiamata.getDurata();
		    tabellaChiamate[i][2] = "" + chiamata.getCosto();
		    i++;
		}
		
		return tabellaChiamate;
		
	}
	
	public static void main(String[] args){
		
		
		
		ContrattoFisso fisso = new ContrattoFisso("Marco", "345678901", "Roma");
		ContrattoMobile mobile = new ContrattoMobile("Gianna", "123456789");
		

		
		for (int i = 0; i < 8; i++) {
			fisso.chiamata(RandomNumber.randomInt(1, 1000));
			mobile.chiamata(RandomNumber.randomInt(1, 1000));
		}
		
		LocalDate currentDate = LocalDate.now();
		
		System.out.println(textBolletta(fisso, currentDate));
		System.out.println(textBolletta(mobile, currentDate));
		

		FileWriters.scriviTXT(fisso, "OutputFile\\bolletta" + fisso.getClass().getName() + ".txt", textBolletta(fisso, currentDate));
		FileWriters.scriviTXT(mobile, "OutputFile\\bolletta" + mobile.getClass().getName() + ".txt", textBolletta(mobile, currentDate));

		FileWriters.scriviPDF(fisso, "OutputFile\\bolletta" + fisso.getClass().getName() + ".pdf", textBolletta(fisso, currentDate));
		FileWriters.scriviPDF(mobile, "OutputFile\\bolletta" + mobile.getClass().getName() + ".pdf", textBolletta(mobile, currentDate));

		FileWriters.scriviCSV(fisso, "OutputFile\\bolletta" + fisso.getClass().getName() + ".csv", header(), data(fisso));
		FileWriters.scriviCSV(mobile, "OutputFile\\bolletta" + mobile.getClass().getName() + ".csv", header(), data(mobile));


	}

}
