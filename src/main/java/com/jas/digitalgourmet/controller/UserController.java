package com.jas.digitalgourmet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jas.digitalgourmet.controller.dto.ErrorMessageDTO;
import com.jas.digitalgourmet.controller.dto.UserDTO;
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
	@ApiOperation(value = "Get All User", notes = "List of all users")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> getAllUser(@RequestParam(value = "isActive") Boolean isActive) {

		try {
			List<UserDTO> userList = service.findAllUser(isActive);
			return ResponseEntity.ok().body(userList);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@PostMapping
	@ApiOperation(value = "Create User", notes = "Create user and encrypted password")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful request"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> saveOrUpdateUser(@RequestBody UserDTO user) {

		try {
			service.saveOrUpdateUser(user);
			return ResponseEntity.ok().body(Boolean.TRUE);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@DeleteMapping
	@ApiOperation(value = "Logical Delete", notes = "Delete User By ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Saccesfully"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> deleteUserById(@RequestParam(value = "oid") Long OID) {

		try {
			service.inactiveObjectById(OID);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ApiOperation(value = "Get User By id", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ge t User Saccesfully"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> getUserById(@RequestParam(value = "oid") Long OID) {

		try {
			UserDTO user = service.getUserById(OID);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

}
