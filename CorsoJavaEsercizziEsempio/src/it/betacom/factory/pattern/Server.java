package it.betacom.factory.pattern;

public class Server extends Macchina {
	
	public Server(String cpu, int ram, int hardDrive) {
		super(cpu, ram, hardDrive);
	}
	
	@Override
	public String toString() {
		return "Macchina di tipo *Server* \nCPU: " + getCpu() + "\nRAM: " + getRam() + "\nHardDrive: " + getHardDrive();
	}

}
