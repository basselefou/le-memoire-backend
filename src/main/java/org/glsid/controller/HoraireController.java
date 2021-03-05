package org.glsid.controller;

import java.util.List;

import org.glsid.entitie.Horaire;
import org.glsid.service.ServiceHoraire;
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
public class HoraireController {
	@Autowired
	private ServiceHoraire servicehoraire;
	@GetMapping(value="/horaire")
   public List<Horaire> getHoraires() {
		return servicehoraire.getHoraires();
	}
	@GetMapping(value="/horaire/{id}")
    public Horaire getHoraires(@RequestBody Long idhoraire) {
		return servicehoraire.getHoraires(idhoraire);
	}
	@PostMapping(value="/horaire")
	public Horaire saveHoraire(@RequestBody Horaire horaire) {
		return servicehoraire.saveHoraire(horaire);
		
	}
	 @DeleteMapping(value="/horaire/{idhoraire}")
	    public void deleteConge(@PathVariable Long idhoraire) {
			servicehoraire.deleteHoraire(idhoraire);
			
		}
	@PutMapping(value="/horaire/{id}")
	public void updateHoraire(@RequestBody Horaire horaire,@PathVariable Long idhoraire) {
		horaire.setIdhoraire(idhoraire);
		servicehoraire.saveHoraire(horaire);
		
	}

}
