package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Conge;
import org.glsid.entitie.Contrat;
import org.glsid.service.ServiceContrat;
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
public class ContratController {
		@Autowired
		private ServiceContrat servicecontrat;
		@GetMapping(value="/contrat")
		public Collection<Contrat> getContrats(){
			return servicecontrat.getContrats();
		}
		@GetMapping(value="/contrat/{id}")
		public Conge getContrats(@PathVariable Long id){
			return servicecontrat.getContrat(id);
		}
	    @PostMapping(value="/contrat/{id}")
	    public Contrat save(@RequestBody Contrat contrat,@PathVariable Long idemp) {
	    	return servicecontrat.saveContrat(contrat ,idemp);
	    }
	    @DeleteMapping(value="/contrat/{id}")
	    public void deleteConge(@PathVariable Long idcontrat) {
	    	servicecontrat.deleteContrat(idcontrat);
			
		}
	    @PutMapping(value="/contrat/{id}")
	    public void updateConge(@RequestBody Contrat contrat, @PathVariable Long idcontrat) {
			contrat.setIdcontrat(idcontrat);
			servicecontrat.saveContrat(contrat, idcontrat);
		
	    }
	

}
