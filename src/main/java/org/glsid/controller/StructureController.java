package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Horaire;
import org.glsid.entitie.Structure;
import org.glsid.service.ServiceStructure;
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
public class StructureController {
	@Autowired
	private ServiceStructure servicestructure;
	@GetMapping(value="/structure")
	public Collection<Structure> structures(){
		return servicestructure.getStructures();
	}
	@GetMapping(value="/structure/{id}")
	public Structure getStructure(@PathVariable Long id) {
		return servicestructure.getStructure(id);
	}
	@PostMapping(value="/structures/{idhoraire}")
	public Structure saveStructure(@RequestBody Structure structure,@PathVariable(name="idhoraire") Long idhoraire) {
		
		return servicestructure.saveStructure(structure, idhoraire);		
	}
	 @DeleteMapping(value="/structure/{id}")
	    public void deleteConge(@PathVariable Long id) {
			servicestructure.deleteStructure(id);
			
		}
	@PutMapping(value="/structure/{id}")
	public void updateStructure(@RequestBody Structure structure,@PathVariable  Long id) {
		structure.setIdstructure(id);
		servicestructure.saveStructure(structure,id);
	}

}
