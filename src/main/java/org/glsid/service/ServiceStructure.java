package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Structure;

public interface ServiceStructure {
	Structure saveStructure(Structure structure,Long idhoraire);
	List<Structure> getStructures();
	Structure getStructure(Long idstructure);
	void deleteStructure(Long idstructure);
	void updateStructure(Structure structure, Long idstructure);

}
