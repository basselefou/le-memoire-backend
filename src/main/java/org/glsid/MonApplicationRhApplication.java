package org.glsid;

import java.util.Date;

import org.glsid.dao.AbsenceRepository;
import org.glsid.dao.CongeRepository;
import org.glsid.dao.DemandeFormationRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.FormationRepository;
import org.glsid.dao.HoraireRepository;
import org.glsid.dao.PermissionRepository;
import org.glsid.dao.RetardRepository;
import org.glsid.dao.StructureRepository;
import org.glsid.entitie.Absence;
import org.glsid.entitie.AppRole;
import org.glsid.entitie.CompteEmploye;
import org.glsid.entitie.Conge;
import org.glsid.entitie.DemandeFormation;
import org.glsid.entitie.Employe;
import org.glsid.entitie.Formation;
import org.glsid.entitie.Horaire;
import org.glsid.entitie.Permission;
import org.glsid.entitie.Retard;
import org.glsid.entitie.Structure;
import org.glsid.service.AccountService;
import org.glsid.service.ServiceEmploye;
import org.glsid.service.ServiceHoraire;
import org.glsid.service.ServiceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MonApplicationRhApplication implements CommandLineRunner {
	@Autowired
    private ServiceEmploye serviceEmploye;
	@Autowired
	private ServiceStructure serviceStructure;
	@Autowired
	private ServiceHoraire serviceHoraire;
	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired
	private HoraireRepository horairerepository;
	@Autowired
	private StructureRepository structurerepository;
	@Autowired
	private RetardRepository retardrepository;
	@Autowired
	private PermissionRepository permissionrepository;
	@Autowired
	private FormationRepository formationRepository; 
	@Autowired
	public DemandeFormationRepository demandeFormationRepository;
	@Autowired
	public CongeRepository congeRepository;

	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private AccountService accountService;
	
	

	Absence abs=new Absence();
	Employe emp=new Employe();
	Retard ret=new Retard();
	Permission permis=new Permission();
	Formation form1=new Formation();
	Formation form2=new Formation();
	DemandeFormation demandeform=new DemandeFormation();
	Conge conge = new Conge();
	
	public static void main(String[] args) {
		SpringApplication.run(MonApplicationRhApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		//emp.setContrat(null);  
		
		
	
		
		
		
		Horaire horai=new Horaire();
		Horaire horai2=new Horaire();
		horai.setHeuredarriver("8h");
	    horai.setHeuresortie("16h30mn");
	    horai2.setHeuredarriver("7h");
	    horai2.setHeuresortie("16h");
		
		  horairerepository.save(horai);
		    horairerepository.save(horai2);
		
		
		Structure struct1=new Structure();
		Structure struct2=new Structure();
		 struct1.setHoraire(horai);
		    struct2.setHoraire(horai);
		    
		    struct1.setNom("DCHO");
		    struct2.setNom("CPM");
		   
		    structurerepository.save(struct1);
		    structurerepository.save(struct2);
		 
		
		emp.setNom("Niang");
		emp.setPrenom("Bassirou");
		emp.setAdresse("KAOLACK");
		Date datedentree=new Date();
		emp.setDatedentree(datedentree);
		Date datenaissance=new Date();
		emp.setDatenaissance(datenaissance);
		emp.setEmail("bassirou9090@gmail.com");
		emp.setFonction("INGENIEUR RESEAUX");
		emp.setNiveau("ingenieur");
		emp.setSexe("MASCULIN");
		emp.setSpecialite("RESEAUX");
		emp.setTel("777486331");
		emp.setVille("KAOLACK");
		emp.setStructure(struct1);
        emp.setStructure(struct2);
     
        employeRepository.save(emp);
//		serviceEmploye.saveEmploye(emp);
		
        accountService.saveCompteEmploye(new CompteEmploye("admin","1234",true,null,emp));
        accountService.saveCompteEmploye(new CompteEmploye("user","1234",true,null,emp));
//        accountService.saveCompteEmploye(new CompteEmploye("admin","1234",true,null));
//		accountService.saveCompteEmploye(new CompteEmploye("user","1234",true,null));
     	accountService.saveAppRole(new AppRole("ADMIN"));
     	accountService.saveAppRole(new AppRole("USER"));
    	accountService.addAppRoleToCompteEmploye("admin", "ADMIN");
    	accountService.addAppRoleToCompteEmploye("user", "USER");

		
		Date datedebutconge=new Date();
		conge.setDatedebut(datedebutconge);
		Date datefinconge=new Date();
		conge.setDatefin(datefinconge);
		Date daterepriseconge=new Date();
		conge.setDatereprise(daterepriseconge);
		conge.setEmploye(emp);
		conge.setEtatencours(true);
		congeRepository.save(conge);
		
		
	
	    
		
		Date absence=new Date();
	    abs.setDateabsence(absence);
	    Date dateretour=new Date();
	    abs.setDateretour(dateretour);
	    abs.setMotifabsence("MALADE");
     	Date b=new Date();
        abs.setDateabsence(b);
        abs.setEmploye(emp);
        abs.setEtatencours(true);
        absenceRepository.save(abs);
        Date c=new Date();
        ret.setDate(c);
        ret.setDuree("00mm");
        ret.setEmploye(emp);
        ret.setEtatencours(true);
        retardrepository.save(ret);
        
	//serviceEmploye.saveEmploye(new Employe("bass", "niang", new Date(), "", "", "", "", 0, "", new Date(), "", ""));
	   
	    
	    
	    Date e=new Date();
	    permis.setDatedebut(e);
	    Date f=new Date();
	    permis.setDatefin(f);
	    permis.setEmploye(emp);
	    Date datedebut=new Date();
	    permis.setDatedebut(datedebut);
	    Date datefin=new Date();
	    permis.setDatefin(datefin);
	    permis.setMotif("ABSENCE");
	    permis.setType("RETARD");
	    Date datereprise=new Date();
	    permis.setDatereprise(datereprise);
	    permis.setEtatencours(true);
	    permissionrepository.save(permis);
//	   
	    
	    form1.setLibelle("Developeur");
	    form1.setEtatencours(true);
	    form2.setLibelle("Reseaux");
	    form2.setEtatencours(true);
	    formationRepository.save(form1);
	    formationRepository.save(form2);
	    
	    Date dateformation=new Date();
	    demandeform.setDateformation(dateformation);
	    demandeform.setDescription("AUGMENTATION DE NIVEAUX");
	    demandeform.setEmploye(emp);
	    demandeform.setEtatencours(true);
	    demandeform.setFormation(form1);
	    demandeFormationRepository.save(demandeform);
	    
	  
	   

		
	}

}
