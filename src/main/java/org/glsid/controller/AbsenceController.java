package org.glsid.controller;

import java.util.Collection;
import java.util.List;

import org.glsid.entitie.Absence;
import org.glsid.service.ServiceAbsence;
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
public class AbsenceController {
	@Autowired
	private ServiceAbsence serviceabsence;
	
	@GetMapping(value="/absence")
    public List<Absence> getAbsences() {
		return serviceabsence.getAbsences();
	}
	@GetMapping(value="/absenceencours")
	public Collection<Absence> getAbsenceenCours(){
		return serviceabsence.getAbsenceEnCours();
	}
	@GetMapping(value="/absencefinal")
	public Collection<Absence> getAbsencesFinal(){
		return serviceabsence.getAbsencesFinal();
	}
	@GetMapping(value="/absence/{id}")
   public Absence getAbsence(@PathVariable(name="id") Long id) {
	  return serviceabsence.getAbsence(id);
	}
	@PostMapping(value="/validateAbsence/{id}")
	public void ValidateAbsence(@PathVariable Long id){
		Absence absence=serviceabsence.getAbsence(id);
		absence.setEtatfinal(true);
		serviceabsence.saveAbsence(absence,id);
	}
	
	@PostMapping(value="/absence/{idemploye}")
	public Absence saveAbsence(@RequestBody Absence absence, @PathVariable(name="idemploye") Long idemploye) {
		absence.setEtatencours(true);
		return serviceabsence.saveAbsence( absence, idemploye);
	}
	 @DeleteMapping(value="/absence/{id}")
	    public void deleteAbsence(@PathVariable Long id) {
			serviceabsence.deleteAbsence(id);
			
		}
	 @PutMapping(value="/absence/{id}")
	    public void updateAbsence(@RequestBody Absence absence, @PathVariable Long id) {
		 absence.setIdabsence(id);
			serviceabsence.saveAbsence(absence, id);
		
	    }

}
