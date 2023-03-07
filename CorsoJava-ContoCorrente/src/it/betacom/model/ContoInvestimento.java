package it.betacom.model;

import java.time.LocalDate;
import it.betacom.util.*;

public class ContoInvestimento extends Conto {
	
	private double tasso = RandomNumber.randomDouble(-1, 1);

	public ContoInvestimento(String titolare, LocalDate dataApertura, int saldoIniziale ) {
		super(titolare, dataApertura, 0, saldoIniziale);
	}
	
	@Override
	public void preleva(int prelievo, LocalDate dataOperazione) {
		this.aggiornaInteresse(dataOperazione);
		super.preleva(prelievo, dataOperazione);
	}
	
	@Override
	public void versa(int versamento, LocalDate dataOperazione) {
		this.aggiornaInteresse(dataOperazione);
		super.versa(versamento, dataOperazione);
	}
	
	@Override
	public void aggiornaInteresse(LocalDate dataOperazione) {
		super.setInteresse(tasso);
		super.aggiornaInteresse(dataOperazione);
	}

}
