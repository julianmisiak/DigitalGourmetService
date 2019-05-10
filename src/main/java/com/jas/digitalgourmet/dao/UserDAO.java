package com.jas.digitalgourmet.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import com.jas.digitalgourmet.dao.persistentobject.PersistentObjectExtendedDAO;
import com.jas.digitalgourmet.model.User;

public interface UserDAO extends PersistentObjectExtendedDAO<User, Long>{
	User findByUserName(String userName);
	@Query("SELECT u FROM User u WHERE ?1 = false or  u.isActive = ?1 order by u.userName")
	List<User> findAllUser(Boolean isActive);
}
