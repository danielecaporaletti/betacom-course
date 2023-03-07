package it.betacom.factory.pattern;

public class Desktop extends Macchina {
	
	public Desktop(String cpu, int ram, int hardDrive) {
		super(cpu, ram, hardDrive);
	}
	
	@Override
	public String toString() {
		return "Macchina di tipo *Desktop* \nCPU: " + getCpu() + "\nRAM: " + getRam() + "\nHardDrive: " + getHardDrive();
	}

}
