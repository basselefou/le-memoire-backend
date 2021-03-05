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
public class Horaire implements Serializable {
	@Id @GeneratedValue
	private Long idhoraire;
	private String heuredarriver;
	private String heuresortie;
	@JsonIgnore
	@OneToMany(mappedBy="horaire")
	private Collection<Structure> structure;
	
	public Horaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Horaire(String heuredarriver, String heuresortie) {
		super();
		this.heuredarriver = heuredarriver;
		this.heuresortie = heuresortie;
	}
	public Long getIdhoraire() {
		return idhoraire;
	}
	public void setIdhoraire(Long idhoraire) {
		this.idhoraire = idhoraire;
	}
	public String getHeuredarriver() {
		return heuredarriver;
	}
	public void setHeuredarriver(String heuredarriver) {
		this.heuredarriver = heuredarriver;
	}
	public String getHeuresortie() {
		return heuresortie;
	}
	public void setHeuresortie(String heuresortie) {
		this.heuresortie = heuresortie;
	}
	public Collection<Structure> getStructure() {
		return structure;
	}
	public void setStructure(Collection<Structure> structure) {
		this.structure = structure;
	}
	

}
