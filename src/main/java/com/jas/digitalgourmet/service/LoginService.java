package com.jas.digitalgourmet.service;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.controller.dto.TokenWrapper;
import com.jas.digitalgourmet.security.JwtTokenUtil;
import com.jas.digitalgourmet.util.BusinessException;

import static com.jas.digitalgourmet.util.Constant.USUARIO;
import static com.jas.digitalgourmet.util.Constant.PASSWORD;

@Service
public class LoginService {

	private final JwtTokenUtil jwtTokenUtil;

	@Autowired
	public LoginService(JwtTokenUtil jwtTokenUtil) {
		this.jwtTokenUtil = jwtTokenUtil;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public TokenWrapper authenticate(JwtCredentials jwtCredentials) {
		String token = null;
		boolean usuarioMachea = USUARIO.equals(jwtCredentials.getUsername());
		boolean passwordMachea = PASSWORD.equals(jwtCredentials.getPassword());

		if (!usuarioMachea && !passwordMachea) {
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
