package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.HoraireRepository;
import org.glsid.dao.StructureRepository;
import org.glsid.entitie.Horaire;
import org.glsid.entitie.Structure;
import org.glsid.service.ServiceStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
@Service

public class ServiceStructureImpl implements ServiceStructure {
	@Autowired
    private StructureRepository structureRepository;
	@Autowired
	private HoraireRepository horaireRepository; 
	@Override
	public Structure saveStructure(Structure structure ,Long idhoraire) {
		
		Horaire h=horaireRepository.findByIdhoraire(idhoraire);
		structure.setHoraire(h);
		return structureRepository.save(structure);
	}

	@Override
	public List<Structure> getStructures() {
		
		return structureRepository.findAll();
	}

	@Override
	public Structure getStructure(Long idstructure) {
		return structureRepository.findOne(idstructure);
	}

	@Override
	public void deleteStructure(Long idstructure) {
		structureRepository.delete(idstructure);
		
	}

	@Override
	public void updateStructure(Structure structure, Long idstructure) {
		structure.setIdstructure(idstructure);
		structureRepository.save(structure);
		
	}

}
