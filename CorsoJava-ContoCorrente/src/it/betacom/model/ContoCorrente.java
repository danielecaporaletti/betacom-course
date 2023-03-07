package it.betacom.model;

import java.time.LocalDate;

public class ContoCorrente extends Conto{
	
	private static final double TASSO = 0.01;

	public ContoCorrente(String titolare, LocalDate dataApertura, int saldoIniziale) {
		super(titolare, dataApertura, TASSO, saldoIniziale);
	}
	
	@Override
	public void preleva(int prelievo, LocalDate dataOperazione) {
		super.preleva(prelievo, dataOperazione);
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
