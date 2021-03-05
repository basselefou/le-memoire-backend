package org.glsid.dao;

import java.util.List;

import org.glsid.entitie.Absence;
import org.glsid.entitie.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	@Query("SELECT u FROM Permission u WHERE u.etatencours = 1 AND u.etatfinal = 0")
	List<Permission> findPermissionsEnCours();
	
	@Query("SELECT u FROM Permission u WHERE u.etatencours = 1 AND u.etatfinal = 1")
	List<Permission> findPermissionsValides();



}
