package com.jas.digitalgourmet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jas.digitalgourmet.model.Test;
import com.jas.digitalgourmet.model.User;

public interface UserDAO extends JpaRepository<User, Long>{
	User findByUserName(String userName);
}
