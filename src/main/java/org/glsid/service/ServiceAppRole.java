package org.glsid.service;

import java.util.List;

import org.glsid.entitie.AppRole;

public interface ServiceAppRole {
	AppRole saveAppRole(AppRole approle);
	List<AppRole> getAppRoles();
	AppRole getAppRole(Long idRole);
	void deleteAppRole(Long idRole);
	void updateAppRole(AppRole appRole, Long idRole);



}
