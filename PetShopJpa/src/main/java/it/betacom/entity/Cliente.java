package it.betacom.entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String citta;
	private String tel;
	private String indirizzo;
	
    @OneToMany(mappedBy = "cliente")
    private List<Animale> animali;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cognome, String città, String tel, String indirizzo){
		this.nome = nome;
		this.cognome = cognome;
		this.citta = città;
		this.tel = tel;
		this.indirizzo = indirizzo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
    public List<Animale> getAnimali() {
        return animali;
    }
    public void setAnimali(List<Animale> animali) {
        this.animali = animali;
    }
}
