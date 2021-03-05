package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Permission;

public interface ServicePermission {
	Permission savePermission(Permission permission,Long idempl);
	List<Permission> getPermissions();
	List<Permission> getPermissionEnCours();
	List<Permission> getPermissionsFinal();
	Permission getPermission(Long idpermission);
	void deletePermission(Long idpermission);
	void updatePermission(Permission permission, Long idpermission); 

}
