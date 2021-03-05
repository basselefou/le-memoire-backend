package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
	@Query("SELECT u FROM Absence u WHERE u.etatencours = 1 AND u.etatfinal = 0")
	List<Absence> findAbsencesEnCours();
	
	@Query("SELECT u FROM Absence u WHERE u.etatencours = 1 AND u.etatfinal = 1")
	List<Absence> findAbsencesValides();


}
