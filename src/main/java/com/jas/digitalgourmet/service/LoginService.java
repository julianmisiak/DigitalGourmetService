package com.jas.digitalgourmet.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.controller.dto.TokenWrapper;
import com.jas.digitalgourmet.dao.UserDAO;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.security.JwtTokenUtil;
import com.jas.digitalgourmet.util.BusinessException;

@Service
public class LoginService {
	private final JwtTokenUtil jwtTokenUtil;
	private final UserDAO dao;
	
	@Autowired
	public LoginService(JwtTokenUtil jwtTokenUtil, UserDAO dao) {
		this.jwtTokenUtil = jwtTokenUtil;
		this.dao = dao;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public TokenWrapper authenticate(JwtCredentials jwtCredentials) {
		String token = null;
		User user = dao.findByUserName(jwtCredentials.getUsername());
		if(user == null) {
			user = new User();
			user.setUserName("Administrador");
			user.setPassword("1234");
			dao.save(user);
		}
		if (user == null || !user.getPassword().equals(jwtCredentials.getPassword())) {
			throw new BusinessException("Credenciales invalidas");
		}
		try {
			token = jwtTokenUtil.generateJWT(jwtCredentials);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new TokenWrapper(token);
	}
}
