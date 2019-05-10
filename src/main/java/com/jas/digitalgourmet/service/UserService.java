package com.jas.digitalgourmet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.controller.dto.UserDTO;
import com.jas.digitalgourmet.dao.UserDAO;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.service.translateobject.TranslateObject;
import com.jas.digitalgourmet.util.BusinessException;
import com.jas.digitalgourmet.util.PasswordUtils;

@Service
public class UserService {
	private final UserDAO dao;

	public UserService(UserDAO dao) {
		this.dao = dao;
	}

	public List<UserDTO> findAllUser(Boolean isActive) {
		
		List<User> userList =  dao.findAllUser(isActive);
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		
		userList.forEach(user -> {
			UserDTO userDTO = TranslateObject.getInstance().translateToDTO(user);
			userDTOList.add(userDTO);
		});
		
		return userDTOList;
	}

	public Integer inactiveObjectById(Long userOID) {
		return dao.inactiveObjectById(userOID);
	}

	public User saveOrUpdateUser(UserDTO userDTO) {
		try {
		User user = TranslateObject.getInstance().translateToPersistentObject(userDTO);
		if(user.getOID() == null) {
			String securePassword = generatSecurePassword(user);
			user.setPassword(securePassword);
		}
		return dao.save(user);
		}catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new BusinessException("Nombre de usuario existente");
		}
	}

	private String generatSecurePassword(User user) {
		String securePassword = PasswordUtils.generateSecurePassword(user.getPassword());
		return securePassword;

	}

	public UserDTO getUserById(Long OID) {
		User user = dao.findById(OID).get();
		return TranslateObject.getInstance().translateToDTO(user);
		
	}

}
