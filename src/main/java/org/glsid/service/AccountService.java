package org.glsid.service;

import org.glsid.entitie.CompteEmploye;
import org.glsid.entitie.AppRole;


public interface AccountService {
	public CompteEmploye saveCompteEmploye(CompteEmploye compteEmploye);
    public AppRole saveAppRole(AppRole role);
	public void addAppRoleToCompteEmploye(String username ,String libelle);
	public CompteEmploye findCompteEmployeByUsername(String username);

}
