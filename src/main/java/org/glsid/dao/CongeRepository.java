package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CongeRepository extends JpaRepository<Conge, Long> {
	@Query("SELECT u FROM Conge u WHERE u.etatencours = 1 AND u.etatfinal = 0")
	List<Conge> findCongesEnCours();
	
	@Query("SELECT u FROM Conge u WHERE u.etatencours = 1 AND u.etatfinal = 1")
	List<Conge> findCongesValides();

}
