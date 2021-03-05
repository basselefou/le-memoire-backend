package org.glsid.entitie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Structure implements Serializable {
	@Id @GeneratedValue
	private Long idstructure;
	private String nom;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idhoraire")
	
	private Horaire horaire;
	
	@JsonIgnore
	@OneToMany(mappedBy="structure")
	private Collection<Employe> employes;
	
	public Structure() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Structure(String nom) {
		super();
		this.nom = nom;
	}
	public Long getIdstructure() {
		return idstructure;
	}
	public void setIdstructure(Long idstructure) {
		this.idstructure = idstructure;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Horaire getHoraire() {
		return horaire;
	}
	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	

}
