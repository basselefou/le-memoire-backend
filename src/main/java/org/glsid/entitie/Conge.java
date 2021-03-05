package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

@Entity
public class Conge implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idconge;
	private Date datedebut;
	private Date datefin;
	private Date datereprise;
	private String typeconge;
//	private boolean etatbrouillons;
	private boolean etatencours;
	private boolean etatfinal;
	
	@ManyToOne
	@JoinColumn(name="idemploye")
	private Employe employe;
	
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Conge(Date datedebut, Date datefin, Date datereprise, String typeconge, boolean etatbrouillons,
			boolean etatencours, boolean etatfinal) {
		super();
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.datereprise = datereprise;
		this.typeconge = typeconge;
//		this.etatbrouillons = etatbrouillons;
		this.etatencours = etatencours;
		this.etatfinal = etatfinal;
	}
	public Long getIdconge() {
		return idconge;
	}
	public void setIdconge(Long idconge) {
		this.idconge = idconge;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public Date getDatereprise() {
		return datereprise;
	}
	public void setDatereprise(Date datereprise) {
		this.datereprise = datereprise;
	}
	public String getTypeconge() {
		return typeconge;
	}
	public void setTypeconge(String typeconge) {
		this.typeconge = typeconge;
	}
//	public boolean isEtatbrouillons() {
//		return etatbrouillons;
//	}
//	public void setEtatbrouillons(boolean etatbrouillons) {
//		this.etatbrouillons = etatbrouillons;
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
	
	

}
