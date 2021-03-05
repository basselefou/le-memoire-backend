package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Permission implements Serializable {
	@Id @GeneratedValue
	private Long idpermission;
	private String type;
	private String motif;
	private Date datedebut;
	private Date datefin;
	private Date datereprise;
	private boolean etatencours;
	private boolean etatfinal;
	public Permission(String type, String motif, Date datedebut, Date datefin, Date datereprise, boolean etatencours,
			boolean etatfinal, Employe employe) {
		super();
		this.type = type;
		this.motif = motif;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.datereprise = datereprise;
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
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Permission(String type, String motif, Date datedebut, Date datefin, Date datereprise) {
//		super();
//		this.type = type;
//		this.motif = motif;
//		this.datedebut = datedebut;
//		this.datefin = datefin;
//		this.datereprise = datereprise;
//	}
	public Long getIdpermission() {
		return idpermission;
	}
	public void setIdpermission(Long idpermission) {
		this.idpermission = idpermission;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	

}
