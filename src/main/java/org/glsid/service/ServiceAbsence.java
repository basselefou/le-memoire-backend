package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Absence;
import org.glsid.entitie.Conge;

public interface ServiceAbsence {
	Absence saveAbsence(Absence absence ,Long idemploye);
	List<Absence> getAbsences();
	List<Absence> getAbsenceEnCours();
	List<Absence> getAbsencesFinal();
	Absence getAbsence(Long idabsence);
	void deleteAbsence(Long idabsence);
	void updateAbsence(Absence absence, Long idabsence); 
}
