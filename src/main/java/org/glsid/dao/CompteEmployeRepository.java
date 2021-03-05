package org.glsid.dao;

import org.glsid.entitie.CompteEmploye;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteEmployeRepository extends JpaRepository<CompteEmploye, Long> {
	public CompteEmploye findByUsername(String username);

//	public CompteEmploye findById(Long id);

}
