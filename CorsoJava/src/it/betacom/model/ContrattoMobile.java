package it.betacom.model;

public class ContrattoMobile extends ContrattoTelefonico{
	
	public final double COSTO_ALLA_RISPOSTA = 0.5;

	public ContrattoMobile(String name, String numTel) {
		
		super(name, numTel);
		
	}
	
	@Override
	public void chiamata(int tempoChiamata) {
		
		super.chiamtaCostiAggintivi(tempoChiamata, COSTO_ALLA_RISPOSTA);

		
	}
	

}
