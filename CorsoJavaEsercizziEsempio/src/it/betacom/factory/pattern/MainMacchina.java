package it.betacom.factory.pattern;

public class MainMacchina {
	

	
	public static void main(String[] args) {
		
		MacchinaFactory factory = new MacchinaFactory();
		
		System.out.println(factory.tipoDiMacchina("Desktop", "IntelI5", 6, 24).toString());
		
		System.out.println(factory.tipoDiMacchina("Server", "IntelI7", 12, 100).toString());
		
		System.out.println(factory.tipoDiMacchina("Notebook", "IntelI3", 4, 24).toString());
		
	}
	
	

}
