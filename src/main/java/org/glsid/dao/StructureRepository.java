package org.glsid.dao;

import org.glsid.entitie.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

public interface StructureRepository extends JpaRepository<Structure, Long> {

	Structure findByIdstructure(Long idstructure);


}
