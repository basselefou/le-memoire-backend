package org.glsid.controller;

import java.util.Collection;
import java.util.List;

import org.glsid.entitie.Absence;
import org.glsid.entitie.Permission;
import org.glsid.service.ServicePermission;
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
public class PermissionController {
		@Autowired
		private ServicePermission servicepermission;
		
		@GetMapping(value="/permission")
		public List<Permission> getPermissions() {
			
			return servicepermission.getPermissions();
		}
		@GetMapping(value="/permissionencours")
		public Collection<Permission> getPermissionenCours(){
			return servicepermission.getPermissionEnCours();
		}
		@GetMapping(value="/permissionfinal")
		public Collection<Permission> getPermissionsFinal(){
			return servicepermission.getPermissionsFinal();
		}
		@GetMapping(value="/permission/{id}")
		public Permission getPermissions(@PathVariable Long id){
			return servicepermission.getPermission(id);
		}
	    @PostMapping(value="/permission/{idemploye}")
	    public Permission save(@RequestBody Permission permission,@PathVariable(name="idemploye") Long idemploye) {
	    	permission.setEtatencours(true);
	    	return servicepermission.savePermission(permission,idemploye);
	    }
	    @PostMapping(value="/validatePermission/{id}")
		public void ValidatePermission(@PathVariable Long id){
	    	Permission permission=servicepermission.getPermission(id);
			permission.setEtatfinal(true);
			servicepermission.savePermission(permission,id);
		}
	    @DeleteMapping(value="/permission/{idpermission}")
	    public void deletePermission(@PathVariable Long idpermission) {
	    	servicepermission.deletePermission(idpermission);
			
		}
	    @PutMapping(value="/permission/{idpermission}")
	    public void updatePermission(@RequestBody Permission permission, @PathVariable Long idpermission) {
	    	permission.setIdpermission(idpermission);
			servicepermission.savePermission(permission, idpermission);
		
	    }

}
