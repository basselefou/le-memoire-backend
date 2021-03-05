package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Absence implements Serializable {
	@Id @GeneratedValue
	private Long idabsence;
	private Date dateabsence;
	private String dureeabsence;
	private Date dateretour;
	private String motifabsence;
	private boolean etatencours;
	private boolean etatfinal;
	
	@ManyToOne
	@JoinColumn(name="idemploye")
	private Employe employe;
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe getEmploye() {
		return employe;
	}
	public Absence(Date dateabsence, String dureeabsence, Date dateretour, String motifabsence, boolean etatencours,
			boolean etatfinal, Employe employe) {
		super();
		this.dateabsence = dateabsence;
		this.dureeabsence = dureeabsence;
		this.dateretour = dateretour;
		this.motifabsence = motifabsence;
		this.etatencours = etatencours;
		this.etatfinal = etatfinal;
		this.employe = employe;
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
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Long getIdabsence() {
		return idabsence;
	}
	public void setIdabsence(Long idabsence) {
		this.idabsence = idabsence;
	}
	public Date getDateabsence() {
		return dateabsence;
	}
	public void setDateabsence(Date dateabsence) {
		this.dateabsence = dateabsence;
	}
	public String getDureeabsence() {
		return dureeabsence;
	}
	public void setDureeabsence(String dureeabsence) {
		this.dureeabsence = dureeabsence;
	}
	public Date getDateretour() {
		return dateretour;
	}
	public void setDateretour(Date dateretour) {
		this.dateretour = dateretour;
	}
	public String getMotifabsence() {
		return motifabsence;
	}
	public void setMotifabsence(String motifabsence) {
		this.motifabsence = motifabsence;
	}
	

}
