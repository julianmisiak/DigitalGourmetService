package com.jas.digitalgourmet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jas.digitalgourmet.dao.persistentobject.PersistentObjectExtendedDAO;
import com.jas.digitalgourmet.model.Role;
import com.jas.digitalgourmet.model.User;

public interface RoleDAO extends PersistentObjectExtendedDAO<Role, Long>{

	@Query("SELECT r FROM Role r WHERE ?1 = false or  r.isActive = ?1 order by r.name")
	List<Role> findAllRoles(Boolean isActive);
}
