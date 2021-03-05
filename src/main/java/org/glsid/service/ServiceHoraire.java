package org.glsid.service;

import java.util.List;

import org.glsid.entitie.Horaire;

public interface ServiceHoraire {
	Horaire saveHoraire(Horaire horaire);
	List<Horaire> getHoraires();
	Horaire getHoraires(Long idhoraire);
	void deleteHoraire(Long idhoraire);
	void updateHoraire(Horaire horaire, Long idhoraire);
	public Horaire findByIdhoraire(Long idh);

}
