package org.glsid.service.impl;

import java.util.List;

import org.glsid.dao.HoraireRepository;
import org.glsid.entitie.Horaire;
import org.glsid.service.ServiceHoraire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ServiceHoraireImpl implements ServiceHoraire  {
	@Autowired
	private HoraireRepository horaireRepository;

	@Override
	public Horaire saveHoraire(Horaire horaire) {
	
		return horaireRepository.save(horaire);
	}

	@Override
	public List<Horaire> getHoraires() {
		
		return horaireRepository.findAll();
	}

	@Override
	public Horaire getHoraires(Long idhoraire) {
		
		return horaireRepository.getOne(idhoraire);
	}

	@Override
	public void deleteHoraire(Long idhoraire) {
		horaireRepository.delete(idhoraire);
		
	}

	@Override
	public void updateHoraire(Horaire horaire, Long idhoraire) {
		horaire.setIdhoraire(idhoraire);
		horaireRepository.save(horaire);
		
	}

	@Override
	public Horaire findByIdhoraire(Long idh) {
		// TODO Auto-generated method stub
		return horaireRepository.findByIdhoraire(idh);
	}

}
