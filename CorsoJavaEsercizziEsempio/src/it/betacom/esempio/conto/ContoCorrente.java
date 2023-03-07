package it.betacom.esempio.conto;

/*
 * COSTRUIRE UNA CLASSE CHE RAPPRESENTI UN CONTO CORRENTE ED ABBIA LE PROPRIETA' DI SALDO 
 * E TITOLARE E I METODI DI PRELIEVO E VERSAMENTO
 * NEL CASO DI PRELIEVO NON DISPONIBILE STAMPI UN MESSAGGIO DI AVVISO
 */

public class ContoCorrente {
	
	private double saldo;
	private String titolare;
	
	public ContoCorrente(double saldo, String titolare) {
		this.saldo = saldo;
		this.titolare = titolare;
	}
	
	public void prelievo(double quantitaDaPrelevare) {
		
			if(saldo - quantitaDaPrelevare >= 0) saldo = saldo - quantitaDaPrelevare;
			else System.out.println("attenzione non hai abbastanza soldi !!!");

	}
	
	public void versamento(double quantitaDaVersare) {
		saldo = saldo + quantitaDaVersare;
	}
	
	@Override
		public String toString() {
			return titolare + ", hai ancora " + saldo + "€";
		}

}
