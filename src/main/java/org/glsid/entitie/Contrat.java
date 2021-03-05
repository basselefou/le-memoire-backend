package org.glsid.entitie;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contrat implements Serializable{
	@Id @GeneratedValue
	private Long idcontrat;
	private String type;
	private Date datedebut;
	private Date datefin;
	@ManyToOne
	@JoinColumn(name="idemploye")
	private Employe employe;
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(Long idcontrat, String type, Date datedebut, Date datefin, Employe employe) {
		super();
		this.idcontrat = idcontrat;
		this.type = type;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.employe = employe;
	}
	public Long getIdcontrat() {
		return idcontrat;
	}
	public void setIdcontrat(Long idcontrat) {
		this.idcontrat = idcontrat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
