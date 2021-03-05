package org.glsid.controller;

import java.util.List;

import org.glsid.dao.DemandeFormationRepository;
import org.glsid.entitie.DemandeFormation;
import org.glsid.service.ServiceDemandeFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DemandeFormationController {
	@Autowired
	private ServiceDemandeFormation servicedemandeformation;
	@Autowired
	private DemandeFormationRepository demandeFormationRepository;
	
	@GetMapping(value="/demandeformation")
    public List<DemandeFormation> getdemandeformation(){
		return servicedemandeformation.getdemandeformation();
	}
	@GetMapping(value="/demandeformationencours")
    public List<DemandeFormation> getdemandeformationEncours(){
		return servicedemandeformation.getDemandeFormationEnCours();
	}
	@GetMapping(value="/demandeformationfinal")
    public List<DemandeFormation> getdemandeformationFinal(){
		return servicedemandeformation.getDemandeFormationFinal();
	}
	@GetMapping(value="/demandeformation/{iddemandeformation}")
   public DemandeFormation getdemandeformation(@PathVariable Long iddemandeformation) {
	  return servicedemandeformation.getDemandeFormation(iddemandeformation);
	}
	@PostMapping(value="/demandeformation/{idemploye}/{idformation}")
	public DemandeFormation saveDemandeFormation(@RequestBody DemandeFormation demandeformation, @PathVariable(name="idemploye") Long idemploye, @PathVariable(name="idformation") Long idformation) {
		demandeformation.setEtatencours(true);
		return servicedemandeformation.saveDemandeFormation( demandeformation, idemploye,idformation);
	}
	 @GetMapping(value="/validerdemandeformation/{id}")
	   public void ValidateDemandeFormation(@PathVariable(name="id") Long id) {
		        DemandeFormation demandeFormation=servicedemandeformation.getDemandeFormation(id);
		        demandeFormation.setEtatfinal(true);
		        demandeFormationRepository.save(demandeFormation);
	 }
	 @DeleteMapping(value="/demandeformation/{iddemandeformation}")
	    public void deleteConge(@PathVariable Long iddemandeformation) {
			servicedemandeformation.deleteDemandeFormation(iddemandeformation);
			
		}
	 @PutMapping(value="/demandeformation/{iddemandeformation}/{idformation}")
	    public void updateDemandeFormation(@RequestBody DemandeFormation demandeformation, @PathVariable Long idemploye, @PathVariable Long idformation) {
		 demandeformation.setIddemandeformation(idemploye);
		 servicedemandeformation.saveDemandeFormation(demandeformation, idemploye,idformation);
	 }
}
