package com.jas.digitalgourmet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.repository.persistentobject.PersistentObjectExtendedRepository;

public interface UserRepository extends PersistentObjectExtendedRepository<User, Long>{
	User findByUserName(String userName);
	@Query("SELECT u FROM User u WHERE ?1 = false or  u.isActive = ?1 order by u.userName")
	List<User> findAllUser(Boolean isActive);
}
