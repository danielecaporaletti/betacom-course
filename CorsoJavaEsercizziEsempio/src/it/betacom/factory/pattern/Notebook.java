package it.betacom.factory.pattern;

public class Notebook extends Macchina {
	
	public Notebook(String cpu, int ram, int hardDrive) {
		super(cpu, ram, hardDrive);
	}
	
	@Override
	public String toString() {
		return "Macchina di tipo *Notebook* \nCPU: " + getCpu() + "\nRAM: " + getRam() + "\nHardDrive: " + getHardDrive();
	}

}
