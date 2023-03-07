package it.betacom.factory.pattern;

public abstract class Macchina {
	
	private String cpu;
	private int ram;
	private int hardDrive;
	
	
	public Macchina(String cpu, int ram, int hardDrive) {
		this.cpu = cpu;
		this.ram = ram;
		this.hardDrive = hardDrive;
	}
	
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getHardDrive() {
		return hardDrive;
	}
	public void setHardDrive(int hardDrive) {
		this.hardDrive = hardDrive;
	}
	
}
