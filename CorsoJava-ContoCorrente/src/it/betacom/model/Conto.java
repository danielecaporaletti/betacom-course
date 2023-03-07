package it.betacom.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Conto {
	
	private String titolare;
	private LocalDate dataApertura;
	private BigDecimal saldo;
	private double tassoInteresse;
	private LocalDate ultimoCheck;
	private List<String> operazioni;
	
	public Conto(String titolare, LocalDate dataApertura, double tassoInteresse, int saldoIniziale) {
		this.titolare = titolare;
		this.dataApertura = dataApertura;
		this.tassoInteresse = tassoInteresse;
		saldo = new BigDecimal(saldoIniziale);
		ultimoCheck = dataApertura;
		operazioni = new ArrayList<String>();
	}
	
	public void preleva(int prelievo, LocalDate oggi) {
		this.aggiornaInteresse(oggi);
		saldo = saldo.subtract(new BigDecimal(prelievo));
		operazioni.add("E' stata eseguita un'operazione di prelievo di " + prelievo + "€ in data " + oggi.toString());	
	}
	
	public void versa(int versamento, LocalDate oggi) {
		this.aggiornaInteresse(oggi);
		saldo = saldo.add(new BigDecimal(versamento));
		operazioni.add("E' stata eseguita un'operazione di versamento di " + versamento + "€ in data " + oggi.toString());
	}
	
	public void aggiornaInteresse(LocalDate oggi) {
		
		int gapDays = (int)ChronoUnit.DAYS.between(ultimoCheck, oggi);
		
		saldo = saldo.add(saldo.multiply(BigDecimal.valueOf((tassoInteresse/365)*gapDays)));
		
		ultimoCheck = oggi;
	}
	
	public void setInteresse(double interesse) {
		tassoInteresse = interesse;
	}
	
	public void cleanOperazioni() {
		operazioni.clear();
	}

	public String toString(LocalDate oggi) {
		return "ESTRATTO CONTO DEL " + oggi.getYear() + "\nConto aperto in data " + dataApertura.toString() + " con proprietario sig. " + 
				titolare + " con saldo rimanente di " + saldo.setScale(2, RoundingMode.HALF_UP).toString() + " €\n\n"
				+ ((!operazioni.isEmpty())? "Le operazioni eseguite sono: \n" + operazioni.toString(): "");
	}

}
