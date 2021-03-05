package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Employe;
import org.glsid.entitie.Horaire;

import org.springframework.stereotype.Service;


public interface ServiceEmploye {
	Employe saveEmploye(Employe employe,Long idstructure);
	List<Employe> getEmployes();
	Employe getEmploye(Long idemploye);
	void deleteEmploye(Long idemploye);
	void updateEmploye(Employe employe, Long idemploye); 
//	public Employe findByIdemploye(Long id);
}
