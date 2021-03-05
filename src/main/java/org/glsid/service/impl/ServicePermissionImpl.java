package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.EmployeRepository;
import org.glsid.dao.PermissionRepository;
import org.glsid.entitie.Employe;
import org.glsid.entitie.Permission;
import org.glsid.service.ServicePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServicePermissionImpl implements ServicePermission  {
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Permission savePermission(Permission permission,Long idemp) {
		Employe employe =employeRepository.getOne(idemp);
		permission.setEmploye(employe);
		permissionRepository.save(permission);
		return null;
	}

	@Override
	public List<Permission> getPermissions() {
		
		return permissionRepository.findAll();
	}

	@Override
	public Permission getPermission(Long idpermission) {
		
		return permissionRepository.findOne(idpermission);
	}

	@Override
	public void deletePermission(Long idpermission) {
		permissionRepository.delete(idpermission);
		
	}

	@Override
	public void updatePermission(Permission permission, Long idpermission) {
		permission.setIdpermission(idpermission);
		permissionRepository.save(permission);
		
	}

	@Override
	public List<Permission> getPermissionEnCours() {
	
		return permissionRepository.findPermissionsEnCours();
	}

	@Override
	public List<Permission> getPermissionsFinal() {
		return permissionRepository.findPermissionsValides();
	}

}
