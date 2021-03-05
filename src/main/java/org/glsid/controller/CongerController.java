package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Conge;
import org.glsid.service.ServiceConge;
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
public class CongerController {
	@Autowired
	private ServiceConge serviceconge;
	@GetMapping(value="/conge")
	public Collection<Conge> getConges(){
		return serviceconge.getConges();
	}
	@GetMapping(value="/congeencours")
	public Collection<Conge> getCongeenCours(){
		return serviceconge.getCongeEnCours();
	}
	@GetMapping(value="/congefinal")
	public Collection<Conge> getCongesFinal(){
		return serviceconge.getCongesFinal();
	}
	@GetMapping(value="/conge/{id}")
	public Conge getConges(@PathVariable Long id){
		return serviceconge.getConge(id);
	}
	
	@PostMapping(value="/validateConge/{id}")
	public void ValidateConge(@PathVariable Long id){
		Conge conge=serviceconge.getConge(id);
		conge.setEtatfinal(true);
		serviceconge.saveConge(conge, id);
	}
	
    @PostMapping(value="/conge/{idemploye}")
    public Conge save(@RequestBody Conge conge,@PathVariable(name="idemploye") Long idemp) {
    	conge.setEtatencours(true);
    	return serviceconge.saveConge(conge,idemp);
    }
    @DeleteMapping(value="/conge/{id}")
    public void deleteConge(@PathVariable Long id) {
		serviceconge.deleteConge(id);
		
	}
    @PutMapping(value="/conge/{id}")
    public void updateConge(@RequestBody Conge conge, @PathVariable Long id) {
		conge.setIdconge(id);
		serviceconge.saveConge(conge, id);
	
    }
}
