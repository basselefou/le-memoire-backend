package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.Conge;
import org.glsid.entitie.DemandeFormation;
import org.glsid.entitie.Formation;
import org.glsid.entitie.Horaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	public Formation findByIdformation(Long idf);
	@Query("SELECT f FROM Formation f WHERE f.etatencours = 1 AND f.etatfinal = 0")
	List<Formation> findFormationsEnCours();
	
	@Query("SELECT f FROM Formation f WHERE f.etatencours = 1 AND f.etatfinal = 1")
	List<Formation> findFormationsValides();

	

}
