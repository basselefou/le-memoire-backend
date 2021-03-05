package org.glsid.dao;

import org.glsid.entitie.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoraireRepository extends JpaRepository<Horaire, Long> {
	public Horaire findByIdhoraire(Long idhoraire);

}
