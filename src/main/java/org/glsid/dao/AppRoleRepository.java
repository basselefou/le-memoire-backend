package org.glsid.dao;

import org.glsid.entitie.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends	JpaRepository<AppRole, Long> {
	public AppRole findByLibelle(String libelle);

}
