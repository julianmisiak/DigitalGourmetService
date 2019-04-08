package com.jas.digitalgourmet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.dao.UserDAO;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.service.translateobject.TranslateObject;
import com.jas.digitalgourmet.util.PasswordUtils;

@Service
public class UserService {
	private final UserDAO dao;

	public UserService(UserDAO dao) {
		this.dao = dao;
	}

	public List<User> findAllUser() {
		return dao.findAllUser();
	}

	public Integer inactiveObjectById(Long userOID) {
		return dao.inactiveObjectById(userOID);
	}

	public User saveOrUpdateUser(UserDTO userDTO) {
		User user = TranslateObject.getInstance().translateToPersistentObject(userDTO);
		String securePassword = generatSecurePassword(user);
		user.setPassword(securePassword);
		return dao.save(user);
	}

	private String generatSecurePassword(User user) {
		String securePassword = PasswordUtils.generateSecurePassword(user.getPassword(), PasswordUtils.getSalt(30));
		return securePassword;

	}

}
