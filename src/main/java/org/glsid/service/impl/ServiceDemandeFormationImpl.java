package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.DemandeFormationRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.FormationRepository;
import org.glsid.entitie.DemandeFormation;
import org.glsid.entitie.Employe;
import org.glsid.entitie.Formation;
import org.glsid.service.ServiceDemandeFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceDemandeFormationImpl implements ServiceDemandeFormation {
	@Autowired
	private DemandeFormationRepository demandeformationRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private FormationRepository formationRepository;

	@Override
	public DemandeFormation saveDemandeFormation(DemandeFormation demandeformation,Long idemploye ,Long idformation) {
		Formation formation=formationRepository.findByIdformation(idformation);
		Employe employe=employeRepository.findByIdemploye(idemploye);
		demandeformation.setEmploye(employe);
		demandeformation.setFormation(formation);
		 demandeformationRepository.save(demandeformation);
		 
		 return null;
	}

	@Override
	public List<DemandeFormation> getdemandeformation() {
		return demandeformationRepository.findAll();
	}

	@Override
	public DemandeFormation getDemandeFormation(Long iddemandeformation) {
		return demandeformationRepository.getOne(iddemandeformation);
	}

	@Override
	public void deleteDemandeFormation(Long iddemandeformation) {
		demandeformationRepository.delete(iddemandeformation);
		
	}

	@Override
	public void updateDemandeFormation(DemandeFormation demandeFormation, Long iddemandeformation) {
		demandeFormation.setIddemandeformation(iddemandeformation);
		demandeformationRepository.save(demandeFormation);
		
	}

	@Override
	public List<DemandeFormation> getDemandeFormationEnCours() {
		return demandeformationRepository.findDemandeFormationsEnCours();
	}

	@Override
	public List<DemandeFormation> getDemandeFormationFinal() {
		return demandeformationRepository.findDemandeFormationsValides();
	}

}
