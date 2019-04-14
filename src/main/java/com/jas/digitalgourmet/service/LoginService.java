package com.jas.digitalgourmet.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.controller.dto.TokenWrapper;
import com.jas.digitalgourmet.dao.UserDAO;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.security.JwtTokenUtil;
import com.jas.digitalgourmet.util.BusinessException;
import com.jas.digitalgourmet.util.PasswordUtils;

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
		User user = dao.findByUserName(jwtCredentials.getUserName());
//
//		if (user != null) {
//			Boolean isValidPassword = PasswordUtils.verifyUserPassword(jwtCredentials.getPassword(), user.getPassword());
//			if (!isValidPassword) {
//				throw new BusinessException("Credenciales invalidas");
//			}
//		}else {
//			throw new BusinessException("Credenciales invalidas");
//		}

		try {
			token = jwtTokenUtil.generateJWT(jwtCredentials);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new TokenWrapper(token);
	}

}
