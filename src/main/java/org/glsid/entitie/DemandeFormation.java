package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DemandeFormation implements Serializable {
	@Id  @GeneratedValue
	private Long iddemandeformation;
	private Date dateformation;
	private String description;
//	private boolean etatbrouillon;
	private boolean etatencours;
	private boolean etatfinal;
	
	@ManyToOne
	@JoinColumn(name="idemploye")
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="idformation")
	private Formation formation;
	public DemandeFormation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemandeFormation(Date dateformation, String description, boolean etatbrouillon, boolean etatencours,
			boolean etatfinal) {
		super();
		this.dateformation = dateformation;
		this.description = description;
//		this.etatbrouillon = etatbrouillon;
		this.etatencours = etatencours;
		this.etatfinal = etatfinal;
	}
	public Long getIddemandeformation() {
		return iddemandeformation;
	}
	public void setIddemandeformation(Long iddemandeformation) {
		this.iddemandeformation = iddemandeformation;
	}
	public Date getDateformation() {
		return dateformation;
	}
	public void setDateformation(Date dateformation) {
		this.dateformation = dateformation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public boolean isEtatbrouillon() {
//		return etatbrouillon;
//	}
//	public void setEtatbrouillon(boolean etatbrouillon) {
//		this.etatbrouillon = etatbrouillon;
//	}
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	

}
