package trash;

public class User {
	
	private String nome;
	private String ruolo;
	
	public User(String nome, String ruolo) {
		this.nome = nome;
		this.ruolo = ruolo;
	}
	
	@Override
	public String toString() {
		return nome + " " + ruolo;
	}

	public String getRuolo() {
		return ruolo;
	}

}
