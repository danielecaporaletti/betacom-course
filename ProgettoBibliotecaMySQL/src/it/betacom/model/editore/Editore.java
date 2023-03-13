package it.betacom.model.editore;

public class Editore {
	
	private int codiceEditore;
	private String nome;
	
	public Editore(int codiceEditore, String nome) {
		this.codiceEditore = codiceEditore;
		this.nome = nome;
	}

	public int getCodiceEditore() {
		return codiceEditore;
	}

	public void setCodiceEditore(int codiceEditore) {
		this.codiceEditore = codiceEditore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
