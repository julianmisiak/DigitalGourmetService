package com.jas.digitalgourmet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.digitalgourmet.controller.dto.ErrorMessageDTO;
import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.model.User;
import com.jas.digitalgourmet.service.LoginService;
import com.jas.digitalgourmet.service.UserService;
import com.jas.digitalgourmet.util.BusinessException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService service;
	
	
	public UserController(UserService service) {
		this.service = service;
	}
	@GetMapping
	@ApiOperation(value = "Get User", notes = "Lista los todos los usuarios")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Acceso al sistema exitoso"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<?> user(@RequestBody(required = false) JwtCredentials jwtCredentials) {

		try {
			List<User> userList = service.findAllUser();
			return ResponseEntity.ok().body(userList);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	
}
