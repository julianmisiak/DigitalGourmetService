package com.jas.digitalgourmet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.digitalgourmet.controller.dto.ErrorMessageDTO;
import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.controller.dto.TokenWrapper;
import com.jas.digitalgourmet.service.LoginService;
import com.jas.digitalgourmet.util.BusinessException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/login")
public class LoginController {
	private LoginService service;

	public LoginController(LoginService service) {
		this.service = service;
	}

	@PostMapping
	@ApiOperation(value = "Login", notes = "Servicio de Login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Acceso al sistema exitoso"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<?> login(@RequestBody JwtCredentials jwtCredentials) {
		try {
			TokenWrapper tocken = service.authenticate(jwtCredentials);
			return ResponseEntity.ok().body(tocken);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
}
