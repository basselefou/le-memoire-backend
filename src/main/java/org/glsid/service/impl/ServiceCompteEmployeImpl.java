package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.CompteEmployeRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entitie.CompteEmploye;
import org.glsid.entitie.Employe;
import org.glsid.service.ServiceCompteEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ServiceCompteEmployeImpl implements ServiceCompteEmploye {
	@Autowired
	private CompteEmployeRepository compteEmployeRepository;
	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public CompteEmploye saveCompteEmploye(CompteEmploye compteemploye, Long idemploye) {
		Employe empl=employeRepository.findByIdemploye(idemploye);
		compteemploye.setEmploye(empl);
		return compteEmployeRepository.save(compteemploye);
	}

	@Override
	public List<CompteEmploye> getCompteEmployes() {
		return compteEmployeRepository.findAll();
	}

	@Override
	public CompteEmploye getCompteEmploye(Long id) {
		return compteEmployeRepository.findOne(id);
	}

	@Override
	public void deleteCompteEmploye(Long id) {
		compteEmployeRepository.delete(id);
		
	}

	@Override
	public void updateCompteEmploye(CompteEmploye compteemploye, Long idemploye) {
		compteemploye.setId(idemploye);
		compteEmployeRepository.save(compteemploye);
		
	}

}
