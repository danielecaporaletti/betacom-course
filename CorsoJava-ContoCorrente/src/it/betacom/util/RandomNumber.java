package it.betacom.util;

import java.util.Random;

/**
 * 
 * @author Daniele Caporaetti
 * 
 * Classe di utilità con metodi statici per ritornare numeri random
 */
public class RandomNumber {
	
	/**
	 * Calcola un numero random intero
	 * 
	 * Metodo che restituisce un intero random tra due specifici valori (min e max)
	 * 
	 * @param min Intero di partenza dell'intervallo
	 * @param max Intero di arrivo dell'intervallo
	 * @return Numero intero randomico all'interno dell'intervallo
	 */
    public static int randomInt(int min, int max) {
        Random random = new Random();
        return ( random.nextInt((max - min) + 1) + min );
    }
    
	/**
	 * Calcola un numero random double
	 * 
	 * Metodo che restituisce un double random tra due specifici valori (min e max)
	 * 
	 * @param min Double di partenza dell'intervallo
	 * @param max Double di arrivo dell'intervallo
	 * @return Numero double randomico all'interno dell'intervallo
	 */
    public static double randomDouble(double min, double max) {
    	Random random = new Random();
    	return ( min + (max - min) * random.nextDouble() );
    }

}
