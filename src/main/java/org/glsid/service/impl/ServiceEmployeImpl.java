package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.CompteEmployeRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.StructureRepository;
import org.glsid.entitie.CompteEmploye;
//import org.glsid.dao.RoleRepository;
import org.glsid.entitie.Employe;
import org.glsid.entitie.Structure;
//import org.glsid.entitie.AppRole;
import org.glsid.service.ServiceEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEmployeImpl implements ServiceEmploye{

	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
    private CompteEmployeRepository compteEmployeRepository;
	@Autowired
	private StructureRepository structureRepository;
	
	@Override
	public Employe saveEmploye(Employe employe,Long idstructure ) {
//		CompteEmploye compte=compteEmployeRepository.findById(id);
//		employe.setCompteEmploye(compte);
		Structure structure=structureRepository.findByIdstructure(idstructure);
		employe.setStructure(structure);
       return employeRepository.save(employe);
	}

	@Override
	public List<Employe> getEmployes() {
		return employeRepository.findAll();
	}

	@Override
	public Employe getEmploye(Long idemploye) {
		return employeRepository.findByIdemploye(idemploye);
	}

	@Override
	public void deleteEmploye(Long idemploye) {
		employeRepository.delete(idemploye);
		
	}

	@Override
	public void updateEmploye(Employe employe, Long idemploye) {
		employe.setIdemploye(idemploye);
		employeRepository.save(employe);
		
	}

//	@Override
//	public Employe findByIdemploye(Long id) {
//		return employeRepository.findByIdemploye(id);
//	}

}
