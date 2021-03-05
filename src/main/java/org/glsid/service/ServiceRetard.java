package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Retard;

public interface ServiceRetard {
	Retard saveRetard(Retard retard, Long idemp);
	List<Retard> getRetards();
	List<Retard> getRetardsEnCours();
	List<Retard> getRetardsFinal();
	Retard getRetard(Long idretard);
	void deleteRetard(Long idretard);
	void updateRetard(Retard retard, Long idretard); 

}
