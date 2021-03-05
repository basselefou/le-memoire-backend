package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Retard implements Serializable {
	@Id @GeneratedValue
	private Long idretard;
	private Date date;
	private String duree;
	private boolean etatencours;
	private boolean etatfinal;
	public Retard(Date date, String duree, boolean etatencours, boolean etatfinal, Employe employe) {
		super();
		this.date = date;
		this.duree = duree;
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
	@ManyToOne
	@JoinColumn(name="idemploye")
	private Employe employe;
	public Retard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Retard(Date date, String duree) {
		super();
		this.date = date;
		this.duree = duree;
	}
	public Long getIdretard() {
		return idretard;
	}
	public void setIdretard(Long idretard) {
		this.idretard = idretard;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	

}
