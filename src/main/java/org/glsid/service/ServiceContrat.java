package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Conge;
import org.glsid.entitie.Contrat;
public interface ServiceContrat {
	Contrat saveContrat(Contrat contrat, Long idemp);
	List<Contrat> getContrats();
	Conge getContrat(Long idcontrat);
	void deleteContrat(Long idcontrat);
	void updateContrat(Contrat contrat,Long idcontrat);


}
