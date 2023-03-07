package it.betacom.daniele;

public class Ciclo1 {

	public static void main(String[] args) {
		
		int i = 0;
		
		for(i=0; i<10; i++) {
			if(i == 4)
				continue;
			System.out.println(i);
		}
		
		System.out.println(i);

	}

}
