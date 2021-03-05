package org.glsid.dao;

import org.glsid.entitie.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EmployeRepository extends JpaRepository<Employe, Long>{
	public Employe findByIdemploye(Long idemploye);

}
