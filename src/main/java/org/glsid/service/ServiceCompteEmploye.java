package org.glsid.service;

import java.util.List;

import org.glsid.entitie.CompteEmploye;

public interface ServiceCompteEmploye {
	CompteEmploye saveCompteEmploye(CompteEmploye compteemploye,Long idemploye);
	List<CompteEmploye> getCompteEmployes();
	CompteEmploye getCompteEmploye(Long id);
	void deleteCompteEmploye(Long id);
	void updateCompteEmploye(CompteEmploye compteemploye, Long idemploye);


}
