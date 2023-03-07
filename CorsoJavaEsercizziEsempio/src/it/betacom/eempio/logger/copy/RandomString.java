package it.betacom.eempio.logger.copy;

import java.util.Random;

public class RandomString {
	
	static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static final int LUNGHEZZA = 10;
    static Random random = new Random();
    
	public static String generator() {
		StringBuilder sb = new StringBuilder(LUNGHEZZA);
        for (int i = 0; i < LUNGHEZZA; i++) {
            sb.append(ALFABETO.charAt(random.nextInt(ALFABETO.length())));
        }
        return sb.toString();
	}

}
