package it.betacom.model;

public class ContrattoFisso extends ContrattoTelefonico{
	
	private String citta;
	
	public ContrattoFisso(String name, String numTel, String citta) {
		
		super(name, numTel);
		this.citta = citta;
		
	}
	
	@Override
	public String getDatiUtente() {
		
		return super.getDatiUtente() + "Città: " + citta;
		
	}
	
	public String getCitta() {
		return citta;
	}

}
