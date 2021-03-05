package org.glsid.service;

import java.util.List;

import org.glsid.entitie.DemandeFormation;
import org.glsid.entitie.Formation;


public interface ServiceDemandeFormation {
	DemandeFormation saveDemandeFormation(DemandeFormation demandeformation,Long idempl,Long idformation);
	List<DemandeFormation> getdemandeformation();
	List<DemandeFormation> getDemandeFormationEnCours();
	List<DemandeFormation> getDemandeFormationFinal();
	DemandeFormation getDemandeFormation(Long iddemandeformation);
	void deleteDemandeFormation(Long iddemandeformation);
	void updateDemandeFormation(DemandeFormation demandeFormation,Long iddemandeformation);

}
