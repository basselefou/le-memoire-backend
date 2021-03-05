package org.glsid.entitie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity

public class Section implements Serializable {
	
	@Id @GeneratedValue
	private Long idsection;
	private String libelle;
	
	
	public Collection<Section> getSections() {
		return sections;
	}
	public void setSections(Collection<Section> sections) {
		this.sections = sections;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	@ManyToMany(mappedBy="employes")
	private Collection<Section> sections;
	
	@ManyToMany(mappedBy = "sections")
	Collection<Employe> employes;
	
	public Section() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Section(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Long getIdsection() {
		return idsection;
	}
	public void setIdsection(Long idsection) {
		this.idsection = idsection;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
