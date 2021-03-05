package org.glsid.entitie;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formation implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idformation;
	private String libelle;
	private boolean etatencours;
	private boolean etatfinal;
	@JsonIgnore
	@OneToMany(mappedBy="formation")
	private Collection<DemandeFormation> demandeFormations;
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Formation(String libelle, boolean etatencours, boolean etatfinal,
			Collection<DemandeFormation> demandeFormations) {
		super();
		this.libelle = libelle;
		this.etatencours = etatencours;
		this.etatfinal = etatfinal;
		this.demandeFormations = demandeFormations;
	}

	public boolean isEtatencours() {
		return etatencours;
	}

	public void setEtatencours(boolean etatencours) {
		this.etatencours = etatencours;
	}

	public boolean isEtatfinal() {
		return etatfinal;
	}

	public void setEtatfinal(boolean etatfinal) {
		this.etatfinal = etatfinal;
	}

//	public Formation(String libelle) {
//		super();
//		this.libelle = libelle;
//	}
	public Long getIdformation() {
		return idformation;
	}
	public void setIdformation(Long idformation) {
		this.idformation = idformation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<DemandeFormation> getDemandeFormations() {
		return demandeFormations;
	}
	public void setDemandeFormations(Collection<DemandeFormation> demandeFormations) {
		this.demandeFormations = demandeFormations;
	}
	

}
