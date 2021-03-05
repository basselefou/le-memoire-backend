package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.CongeRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entitie.Conge;
import org.glsid.entitie.Employe;
import org.glsid.service.ServiceConge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service 
public class ServiceCongeImpl implements ServiceConge {
    @Autowired
	private EmployeRepository employeRepository;
	@Autowired 
	private CongeRepository congeRepository;

	@Override
	public Conge saveConge(Conge conge, Long idemp) {
		Employe employe = employeRepository.getOne(idemp);
		conge.setEmploye(employe);
		congeRepository.save(conge);
		return null;
	}

	@Override
	public List<Conge> getConges() {
	
		return congeRepository.findAll();
	}

	@Override
	public Conge getConge(Long idconge) {
		
		return congeRepository.getOne(idconge);
	}

	@Override
	public void deleteConge(Long idconge) {
		congeRepository.delete(idconge);
		
	}

	@Override
	public void updateConge(Conge conge, Long idconge) {
		conge.setIdconge(idconge);
		congeRepository.save(conge);
		
	}

	@Override
	public List<Conge> getCongeEnCours() {

		return congeRepository.findCongesEnCours();
	}

	@Override
	public List<Conge> getCongesFinal() {
		return congeRepository.findCongesValides();
	}

}
