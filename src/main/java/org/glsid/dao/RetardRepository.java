package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.Retard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RetardRepository extends JpaRepository<Retard, Long> {
	@Query("SELECT r FROM Retard r WHERE r.etatencours = 1 AND r.etatfinal = 0")
	List<Retard> findRetardsEnCours();
	
	@Query("SELECT r FROM Retard r WHERE r.etatencours = 1 AND r.etatfinal = 1")
	List<Retard> findRetardsValides();


}
