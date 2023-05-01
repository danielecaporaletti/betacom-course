package it.betacom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet_shop_user")
public class PetShopUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = true)
	private String telefono;
	@Column(nullable = true, columnDefinition = "enum('MANAGER', 'GUEST')")
	@Enumerated(EnumType.STRING)
	private UseRole role;
	@Column(nullable = true, columnDefinition = "enum('DISABLE', 'ACTIVE')")
	@Enumerated(EnumType.STRING)
	private UseStatus status;
	@Column(nullable = false, columnDefinition = "int default 0")
	private int accessCount;
	@Column(nullable = false, columnDefinition = "char(1) default 'Y'")
	private String changePwd;
	
	public PetShopUser() {
		this.role = UseRole.GUEST;
		this.status = UseStatus.ACTIVE;
		this.accessCount = 0;
		this.changePwd = "Y";
	}
	
	public PetShopUser(String username, String password, String nome, String cognome, String telefono) {
	    this.username = username;
	    this.password = password;
	    this.nome = nome;
	    this.cognome = cognome;
	    this.telefono = telefono;
	    this.role = UseRole.GUEST;
	    this.status = UseStatus.ACTIVE;
	    this.accessCount = 0;
	    this.changePwd = "Y"; 
	}

	public PetShopUser(String username, String password, UseRole role, UseStatus status, String nome, String cognome, String telefono) {
	    this.username = username;
	    this.password = password;
	    this.role = role;
	    this.status = status;
	    this.nome = nome;
	    this.cognome = cognome;
	    this.telefono = telefono;
	    this.accessCount = 0;
	    this.changePwd = "Y"; 
	}
	
    public enum UseRole {
        MANAGER,
        GUEST;
    }

    public enum UseStatus {
        ACTIVE,
        DISABLE;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UseRole getRole() {
		return role;
	}

	public void setRole(UseRole role) {
		this.role = role;
	}

	public UseStatus getStatus() {
		return status;
	}

	public void setStatus(UseStatus status) {
		this.status = status;
	}

	public int getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
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

	public String getTelefono() {
	    return telefono;
	}

	public void setTelefono(String telefono) {
	    this.telefono = telefono;
	}
	
	public String getChangePwd() {
	    return changePwd;
	}

	public void setChangePwd(String changePwd) {
	    this.changePwd = changePwd;
	}
}
