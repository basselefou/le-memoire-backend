package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.CompteEmploye;
import org.glsid.service.ServiceCompteEmploye;
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
public class CompteEmployeController {
	@Autowired
	private ServiceCompteEmploye servicecompteemploye;
	@GetMapping(value="/compteemploye")
	public Collection<CompteEmploye> compteEmployes(){
		return servicecompteemploye.getCompteEmployes();
	}
	@GetMapping(value="/compteemploye/{id}")
	public CompteEmploye getCompteEmploye(@PathVariable Long id) {
		return servicecompteemploye.getCompteEmploye(id);
	}
	@PostMapping(value="/compteemployes/{idemploye}")
	public CompteEmploye saveCompteEmploye(@RequestBody CompteEmploye compteemploye,@PathVariable(name="idemploye") Long idemploye) {
		
		return servicecompteemploye.saveCompteEmploye(compteemploye, idemploye);		
	}
	 @DeleteMapping(value="/compteemploye/{id}")
	    public void deleteCompteEmploye(@PathVariable Long id) {
			servicecompteemploye.deleteCompteEmploye(id);
			
		}
	@PutMapping(value="/compteemploye/{id}")
	public void updateCompteEmploye(@RequestBody CompteEmploye compteemploye,@PathVariable  Long id) {
		compteemploye.setId(id);
		servicecompteemploye.saveCompteEmploye(compteemploye, id);
	}

}
