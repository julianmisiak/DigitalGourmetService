package com.jas.digitalgourmet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.service.LoginService;

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
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Acceso al sistema exitoso"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
    public ResponseEntity<?> login(@RequestBody JwtCredentials jwtCredentials) {
        return ResponseEntity.ok().body(service.authenticate(jwtCredentials));
    }
}
