package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.AbsenceRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entitie.Absence;
import org.glsid.entitie.Employe;
import org.glsid.service.ServiceAbsence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAbsenceImpl implements ServiceAbsence {
	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired 
	private EmployeRepository employeRepository;

	@Override
	public Absence saveAbsence(Absence absence, Long idemploye) {
		Employe employe = employeRepository.getOne(idemploye);
		absence.setEmploye(employe);
		absenceRepository.save(absence);
		return null;
	}

	@Override
	public List<Absence> getAbsences() {
		
		return absenceRepository.findAll();
	}

	@Override
	public Absence getAbsence(Long idabsence) {
		
		return absenceRepository.findOne(idabsence);
	}

	@Override
	public void deleteAbsence(Long idabsence) {
		absenceRepository.delete(idabsence);
		
	}

	@Override
	public void updateAbsence(Absence absence, Long idabsence) {
		absence.setIdabsence(idabsence);
		absenceRepository.save(absence);
		
	}

	@Override
	public List<Absence> getAbsenceEnCours() {
		return absenceRepository.findAbsencesEnCours();
	}

	@Override
	public List<Absence> getAbsencesFinal() {
		return absenceRepository.findAbsencesValides();
	}

}
