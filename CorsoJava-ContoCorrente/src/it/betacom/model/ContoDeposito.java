package it.betacom.model;

import java.time.LocalDate;

public class ContoDeposito extends Conto {
	
	private static final double TASSO = 0.03;

	public ContoDeposito(String titolare, LocalDate dataApertura, int saldoIniziale) {
		super(titolare, dataApertura, TASSO, saldoIniziale);
	}
	
	@Override
	public void preleva(int prelievo, LocalDate dataOperazione) {
		if( (prelievo - 1000) < 0) {
			super.preleva(prelievo, dataOperazione);
		} else {
			System.out.println("Importo da prelevare troppo alto!");
		}
		
	}
	
	@Override
	public void versa(int versamento, LocalDate dataOperazione) {
		super.versa(versamento, dataOperazione);
	}
	
	@Override
	public void aggiornaInteresse(LocalDate oggi) {
		super.aggiornaInteresse(oggi);
		
	}

}
