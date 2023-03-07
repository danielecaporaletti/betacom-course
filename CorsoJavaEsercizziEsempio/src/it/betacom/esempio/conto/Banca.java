package it.betacom.esempio.conto;

public class Banca {

	public static void main(String[] args) {
		
		ContoCorrente persona1 = new ContoCorrente(100, "Luca");
		System.out.print("Benvenuto nella tua banca ");
		System.out.println(persona1.toString());
		System.out.println();
		
		System.out.println("Voi (1)Prelevare o (2)Versare?");
		int scelta = Input.inserisci(1, 2);
		
		if(scelta == 1) {
			double prelievo = 100;
			System.out.println("Vuoi prelevare " + prelievo + "€");
			persona1.prelievo(prelievo);
			System.out.println();
		}
		if(scelta == 2) {
			double versare = 100;
			System.out.println("Vuoi versare " + versare + "€");
			persona1.versamento(versare);
			System.out.println();
		}
		
		System.out.println(persona1.toString());
		
	}

}
