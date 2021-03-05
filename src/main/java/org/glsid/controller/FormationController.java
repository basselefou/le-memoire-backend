package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Formation;
import org.glsid.service.ServiceFormation;
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
public class FormationController {
	@Autowired
	private ServiceFormation serviceformation;
	
	@GetMapping(value="/formation")
	public Collection<Formation> formations(){
		return serviceformation.getFormations();
	}
	@GetMapping(value="/formationencours")
	public Collection<Formation> getFormationEnCours(){
		return serviceformation.getFormationEnCours();
	}
	@GetMapping(value="/formationfinal")
	public Collection<Formation> getFormationFinal(){
		return serviceformation.getFormationsFinal();
	}
	@GetMapping(value="/formation/{idformation}")
	public Formation getFormation(@PathVariable Long idformation) {
		return serviceformation.getFormation(idformation);
	}

	@DeleteMapping(value="/formation/{idformation}")
	public void deleteFormation(@PathVariable Long idformation) {
			serviceformation.deleteFormation(idformation);
			
	}
   @PostMapping(value="/validerformation/{idformation}")
   public void ValidateFormation(@PathVariable Long idformation) {
			Formation formation=serviceformation.getFormation(idformation);
			formation.setEtatfinal(true);
			serviceformation.saveFormation(formation);
			
   } 

  @PostMapping(value="/formation")
  public Formation saveFormation(@RequestBody Formation formation) {
		 formation.setEtatencours(true);
		return serviceformation.saveFormation(formation); 
		
	}
	 @PutMapping(value="/formation/{idformation}")
	public void updateFormation(@RequestBody Formation formation, @PathVariable Long idformation){
		formation.setIdformation(idformation);
		serviceformation.saveFormation(formation);
	}
	
}
