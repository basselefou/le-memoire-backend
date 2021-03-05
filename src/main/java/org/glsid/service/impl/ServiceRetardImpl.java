package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.EmployeRepository;
import org.glsid.dao.RetardRepository;
import org.glsid.entitie.Employe;
import org.glsid.entitie.Retard;
import org.glsid.service.ServiceRetard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceRetardImpl implements ServiceRetard {
	@Autowired
	private RetardRepository retardRepository;
	@Autowired
	private EmployeRepository employeRepository; 

	@Override
	public Retard saveRetard(Retard retard,Long idemp) {
		Employe employe = employeRepository.getOne(idemp);
		retard.setEmploye(employe);
		 retardRepository.save(retard);
		 return null;
		
	}

	@Override
	public List<Retard> getRetards() {
	
		return retardRepository.findAll();
	}

	@Override
	public Retard getRetard(Long idretard) {
	
		return retardRepository.findOne(idretard);
	}

	@Override
	public void deleteRetard(Long idretard) {
		retardRepository.delete(idretard);
		
	}

	@Override
	public void updateRetard(Retard retard, Long idretard) {
		retard.setIdretard(idretard);
		retardRepository.save(retard);
		
	}

	@Override
	public List<Retard> getRetardsEnCours() {
		return retardRepository.findRetardsEnCours();
	}

	@Override
	public List<Retard> getRetardsFinal() {
		return retardRepository.findRetardsValides();
	}

}
