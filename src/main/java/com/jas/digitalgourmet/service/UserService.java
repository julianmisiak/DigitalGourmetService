package com.jas.digitalgourmet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.dao.UserDAO;
import com.jas.digitalgourmet.model.User;

@Service
public class UserService {
	private final UserDAO dao;
	
	public UserService(UserDAO dao) {
		this.dao = dao;
	}
	
	public List<User> findAllUser() {
		return dao.findAllUser();
	}

}
