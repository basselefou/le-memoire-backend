package org.glsid.controller;

import java.util.Collection;

import org.glsid.dao.RetardRepository;
import org.glsid.entitie.Retard;
import org.glsid.service.ServiceRetard;
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
public class RetardController {
@Autowired
private ServiceRetard serviceretard;
@Autowired
private RetardRepository retardRepository;

@GetMapping(value="/retard")
public Collection<Retard> getRetards(){
	return serviceretard.getRetards();
}
@GetMapping(value="/retardencours")
public Collection<Retard> getRetardenCours(){
	return serviceretard.getRetardsEnCours();
}
@GetMapping(value="/retardfinal")
public Collection<Retard> getRetardsFinal(){
	return serviceretard.getRetardsFinal();
}
@GetMapping(value="/retard/{idretard}")
public Retard getRetard(@PathVariable Long idretard) {
	return serviceretard.getRetard(idretard);
}
@PostMapping(value="/validateRetard/{id}")
public void ValidateRetard(@PathVariable(name="id") Long id){
	Retard retard=serviceretard.getRetard(id);
	retard.setEtatfinal(true);
	retardRepository.save(retard);
//	serviceretard.saveRetard(retard, id);
}

@PostMapping(value="/retard/{idemploye}")
public Retard saveRetard(@RequestBody Retard retard,@PathVariable(name="idemploye") Long idemploye) {
	retard.setEtatencours(true);
	return serviceretard.saveRetard(retard, idemploye);
}
@DeleteMapping(value="/retard/{idretard}")
public void deleteConge(@PathVariable Long idretard) {
	serviceretard.deleteRetard(idretard);
	
}
@PutMapping(value="/retard/{idretard}")
public void updateRetard(@RequestBody Retard retard,@PathVariable Long idretard) {
	retard.setIdretard(idretard);
	serviceretard.saveRetard(retard, idretard);
}
}
