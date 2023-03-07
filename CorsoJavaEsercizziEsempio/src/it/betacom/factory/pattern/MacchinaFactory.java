package it.betacom.factory.pattern;

public class MacchinaFactory {
	
	public Macchina tipoDiMacchina(String macchina, String cpu, int ram, int hardDrive) {
		
		if (macchina.equalsIgnoreCase("Desktop")) {
			
			return new Desktop(cpu, ram, hardDrive);
			
		} else if (macchina.equalsIgnoreCase("Server")) {
			
			return (ram < 32)? new Server(cpu, 32, hardDrive): new Server(cpu, ram, hardDrive);
			
		} else if (macchina.equalsIgnoreCase("Notebook")) {
			
			return new Notebook(cpu, ram, hardDrive);
			
		} else {
			
			return null;
		
		}
		
	}

}
