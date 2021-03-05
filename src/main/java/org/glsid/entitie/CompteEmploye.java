package org.glsid.entitie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class CompteEmploye implements Serializable {
	@Id @GeneratedValue
	private Long id; 
	@Column(unique=true)
	private String username;
	private String password;
 	private boolean active;
 	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idemploye")
	private Employe employe;
	

public CompteEmploye(String username, String password, boolean active, Collection<AppRole> roles, Employe employe) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.employe = employe;
	}
public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	// 	@JsonIgnore
//	@OneToMany(mappedBy="compteEmploye")
//	private Collection<Employe> employes;
//	
//	
//	public CompteEmploye(String username, String password, boolean active, Collection<Employe> employes) {
//	super();
//	this.username = username;
//	this.password = password;
//	this.active = active;
////	this.employes = employes;
//}
	public CompteEmploye() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//public CompteEmploye(String username, String password, boolean active, Collection<AppRole> roles,
//			Collection<Employe> employes) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.active = active;
//		this.roles = roles;
////		this.employes = employes;
//	}

	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
//	public Collection<Employe> getEmployes() {
//		return employes;
//	}
//	public void setEmployes(Collection<Employe> employes) {
//		this.employes = employes;
//	}
	public void setId(Long id) {
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}


}
