package org.glsid.service;
import java.util.List;

import org.glsid.entitie.Formation;

public interface ServiceFormation {
	Formation saveFormation(Formation formation);
	List<Formation> getFormations();
	List<Formation> getFormationEnCours();
	List<Formation> getFormationsFinal();
	Formation getFormation(Long idformation);
	void deleteFormation(Long idformation);
	void updateFormation(Formation formation, Long idformation);
	public Formation findByIdformation(Long idf);

}