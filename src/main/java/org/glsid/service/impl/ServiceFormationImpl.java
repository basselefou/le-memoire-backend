package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.FormationRepository;
import org.glsid.entitie.Formation;
import org.glsid.service.ServiceFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFormationImpl implements ServiceFormation {
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public Formation saveFormation(Formation formation) {
		return formationRepository.save(formation);
	}

	@Override
	public List<Formation> getFormations() {
		return formationRepository.findAll();
	}

	@Override
	public Formation getFormation(Long idformation) {
		return formationRepository.findOne(idformation);
	}

	@Override
	public void deleteFormation(Long idformation) {
		formationRepository.delete(idformation);
		
	}

	@Override
	public void updateFormation(Formation formation, Long idformation) {
		formation.setIdformation(idformation);
		formationRepository.save(formation);
		
	}

	@Override
	public Formation findByIdformation(Long idf) {
		return formationRepository.findByIdformation(idf);
	}

	@Override
	public List<Formation> getFormationEnCours() {
		return formationRepository.findFormationsEnCours();
	}

	@Override
	public List<Formation> getFormationsFinal() {
		return formationRepository.findFormationsValides();
	}


}
