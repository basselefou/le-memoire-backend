package org.glsid.entitie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Employe implements Serializable {
	
	@Id @GeneratedValue
	private Long idemploye;
	private String prenom;
	private String nom;
	private Date datenaissance;
	private String email;
	private String adresse;
	private String sexe;
	private String ville;
	private String tel;
	private String niveau;
	private Date datedentree;
	private String specialite;
	private String fonction;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private List<Retard> retard;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<Conge> conges;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<Absence> absences;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<Permission> permissions;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<Contrat> contrats;
	
	@ManyToOne
	@JoinColumn(name="idstructure")
	private Structure structure;
	
	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<CompteEmploye> compteEmployes;

	@JsonIgnore
	@OneToMany(mappedBy="employe")
	private Collection<DemandeFormation> demandeFormations;
	
	@JsonIgnore
	@ManyToMany()
	@JoinTable(name = "Affectation", joinColumns = @JoinColumn(name = "idemploye"),inverseJoinColumns = @JoinColumn(name = "idsection"))
	Collection<Section> sections;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
    }
//	@ManyToOne
//	@JoinColumn(name="id")
//	private CompteEmploye compteEmploye;
//	//@ManyToMany(mappedBy="sections",fetch=FetchType.EAGER)
//	//private Collection<Employe> employes;
	
	public List<Retard> getRetard() {
		return retard;
	}

	public Collection<CompteEmploye> getCompteEmployes() {
		return compteEmployes;
	}

	public void setCompteEmployes(Collection<CompteEmploye> compteEmployes) {
		this.compteEmployes = compteEmployes;
	}
	

public Employe(String prenom, String nom, Date datenaissance, String email, String adresse, String sexe,
			String ville, String tel, String niveau, Date datedentree, String specialite, String fonction,
			List<Retard> retard, Collection<Conge> conges, Collection<Absence> absences,
			Collection<Permission> permissions, Structure structure, Collection<CompteEmploye> compteEmployes,
			Collection<DemandeFormation> demandeFormations) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.datenaissance = datenaissance;
		this.email = email;
		this.adresse = adresse;
		this.sexe = sexe;
		this.ville = ville;
		this.tel = tel;
		this.niveau = niveau;
		this.datedentree = datedentree;
		this.specialite = specialite;
		this.fonction = fonction;
		this.retard = retard;
		this.conges = conges;
		this.absences = absences;
		this.permissions = permissions;
		this.structure = structure;
		this.compteEmployes = compteEmployes;
		this.demandeFormations = demandeFormations;
	}



	public void setRetard(List<Retard> retard) {
		this.retard = retard;
	}
	public Collection<Conge> getConges() {
		return conges;
	}
	public void setConges(Collection<Conge> conges) {
		this.conges = conges;
	}
	public Collection<Absence> getAbsences() {
		return absences;
	}
	public void setAbsences(Collection<Absence> absences) {
		this.absences = absences;
	}
	public Collection<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Structure getStructure() {
		return structure;
	}
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	public Collection<DemandeFormation> getDemandeFormations() {
		return demandeFormations;
	}
	public void setDemandeFormations(Collection<DemandeFormation> demandeFormations) {
		this.demandeFormations = demandeFormations;
	}
	public Collection<Section> getSections() {
		return sections;
	}
	public void setSections(Collection<Section> sections) {
		this.sections = sections;
	}
	

	public Long getIdemploye() {
		return idemploye;
	}
	public void setIdemploye(Long idemploye) {
		this.idemploye = idemploye;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public Date getDatedentree() {
		return datedentree;
	}
	public void setDatedentree(Date datedentree) {
		this.datedentree = datedentree;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	
}
