package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.AppRoleRepository;
import org.glsid.entitie.AppRole;
import org.glsid.service.ServiceAppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAppRoleImpl implements ServiceAppRole{
	@Autowired
	private AppRoleRepository appRoleRepository;

	@Override
	public AppRole saveAppRole(AppRole approle) {
		return appRoleRepository.save(approle);
	}

	@Override
	public List<AppRole> getAppRoles() {
		return appRoleRepository.findAll();
	}

	@Override
	public AppRole getAppRole(Long idRole) {
		return appRoleRepository.findOne(idRole);
	}

	@Override
	public void deleteAppRole(Long idRole) {
		appRoleRepository.delete(idRole);
		
	}

	@Override
	public void updateAppRole(AppRole appRole, Long idRole) {
		appRole.setIdRole(idRole);
		appRoleRepository.save(appRole);
		
	}

}
