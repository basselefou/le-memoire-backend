package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Conge;

public interface ServiceConge {
	Conge saveConge(Conge conge, Long idemp);
	List<Conge> getConges();
	List<Conge> getCongeEnCours();
	List<Conge> getCongesFinal();
	Conge getConge(Long idconge);
	void deleteConge(Long idconge);
	void updateConge(Conge conge,Long idconge);
	

}
