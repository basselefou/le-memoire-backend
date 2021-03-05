package org.glsid.service.impl;

import org.glsid.dao.AppRoleRepository;
import org.glsid.dao.CompteEmployeRepository;
import org.glsid.entitie.AppRole;
import org.glsid.entitie.CompteEmploye;
import org.glsid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountServiceImpl implements AccountService	 {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private CompteEmployeRepository compteEmployeRepository;
	@Autowired
	private AppRoleRepository approleRepository;

	@Override
	public CompteEmploye saveCompteEmploye(CompteEmploye compteEmploye) {
		String hashPW=bCryptPasswordEncoder.encode(compteEmploye.getPassword());
		compteEmploye.setPassword(hashPW);
		return compteEmployeRepository.save(compteEmploye);
	}

	@Override
	public AppRole saveAppRole(AppRole role) {
		return approleRepository.save(role);
	}

	@Override
	public void addAppRoleToCompteEmploye(String username, String libelle) {
		CompteEmploye compteEmploye=compteEmployeRepository.findByUsername(username);
		AppRole role=approleRepository.findByLibelle(libelle);
		compteEmploye.getRoles().add(role); 
		
	}

	@Override
	public CompteEmploye findCompteEmployeByUsername(String username) {
		return compteEmployeRepository.findByUsername(username);
	}

}
