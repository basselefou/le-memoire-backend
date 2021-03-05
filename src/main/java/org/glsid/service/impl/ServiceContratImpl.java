package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.ContratRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entitie.Conge;
import org.glsid.entitie.Contrat;
import org.glsid.entitie.Employe;
import org.glsid.service.ServiceContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceContratImpl implements ServiceContrat{
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private EmployeRepository employeRepository;
	

	@Override
	public Contrat saveContrat(Contrat contrat, Long idemp) {
		Employe employe=employeRepository.getOne(idemp);
		contrat.setEmploye(employe);
		contratRepository.save(contrat);
		return null;
	}

	@Override
	public List<Contrat> getContrats() {
		contratRepository.findAll();
		return null;
	}

	@Override
	public Conge getContrat(Long idcontrat) {
		contratRepository.getOne(idcontrat);
		return null;
	}

	@Override
	public void deleteContrat(Long idcontrat) {
		contratRepository.delete(idcontrat);
		
	}

	@Override
	public void updateContrat(Contrat contrat, Long idcontrat) {
		contrat.setIdcontrat(idcontrat);
		contratRepository.save(contrat);
		
	}

}
