package org.glsid.entitie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AppRole implements Serializable{
	@Id @GeneratedValue
	private Long idRole;
	private String libelle;
	
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppRole(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
