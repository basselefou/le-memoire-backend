package org.glsid.controller;

import java.util.Collection;

import org.glsid.entitie.Employe;
import org.glsid.service.ServiceEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmployeController {
	@Autowired
	private ServiceEmploye serviceemploye;
	@GetMapping(value="/employe")
    public Collection<Employe> getEmployes(){
    	return serviceemploye.getEmployes();
    }
	@RequestMapping(value="/employe/{id}",method=RequestMethod.GET)
    public Employe getEmploye(@PathVariable Long id){
    	return serviceemploye.getEmploye(id);
	}

	@RequestMapping(value="/employes/{idstructure}",method=RequestMethod.POST)
    public Employe save(@RequestBody Employe emp,@PathVariable(name="idstructure") Long idstructure){
    	return serviceemploye.saveEmploye(emp,idstructure);
	}
	@RequestMapping(value="/employe/{id}",method=RequestMethod.DELETE)
    public  void deleteEmploye(@PathVariable Long id){
		 serviceemploye.deleteEmploye(id);
    	 
	}
	@RequestMapping(value="/employe/{id}",method=RequestMethod.PUT)
    public void update(@PathVariable Long id,@RequestBody Employe emp){
		emp.setIdemploye(id);
    	serviceemploye.updateEmploye(emp,id);
	}
	
}
