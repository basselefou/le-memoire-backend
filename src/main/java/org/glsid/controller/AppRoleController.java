package org.glsid.controller;

import java.util.List;

import org.glsid.entitie.AppRole;
import org.glsid.entitie.Horaire;
import org.glsid.service.ServiceAppRole;
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
public class AppRoleController {
	@Autowired
	private ServiceAppRole serviceAppRole;
	@GetMapping(value="/approle")
   public List<AppRole> getAppRoles() {
		return serviceAppRole.getAppRoles();
	}
	@GetMapping(value="/approle/{idRole}")
    public AppRole getAppRoles(@RequestBody Long idRole) {
		return serviceAppRole.getAppRole(idRole);
	}
	@PostMapping(value="/approles")
	public AppRole saveAppRole(@RequestBody AppRole approle) {
		return serviceAppRole.saveAppRole(approle);
		
	}
	 @DeleteMapping(value="/approle/{idRole}")
	    public void deleteAppRole(@PathVariable Long idRole) {
			serviceAppRole.deleteAppRole(idRole);
			
		}
	@PutMapping(value="/approle/{idRole}")
	public void updateAppRole(@RequestBody AppRole approle,@PathVariable Long idRole) {
		approle.setIdRole(idRole);
		serviceAppRole.saveAppRole(approle);
		
	}


}
