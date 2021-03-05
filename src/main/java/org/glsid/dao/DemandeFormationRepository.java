package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.DemandeFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DemandeFormationRepository extends JpaRepository<DemandeFormation, Long> {
	
	@Query("SELECT f FROM DemandeFormation f WHERE f.etatencours = 1 AND f.etatfinal = 0")
	List<DemandeFormation> findDemandeFormationsEnCours();
	
	@Query("SELECT f FROM DemandeFormation f WHERE f.etatencours = 1 AND f.etatfinal = 1")
	List<DemandeFormation> findDemandeFormationsValides();


}
