package com.jas.digitalgourmet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jas.digitalgourmet.model.User;

public interface UserDAO extends JpaRepository<User, Long>{
	User findByUserName(String userName);

	@Query("SELECT U FROM User U")
	List<User> findAllUser();
}
