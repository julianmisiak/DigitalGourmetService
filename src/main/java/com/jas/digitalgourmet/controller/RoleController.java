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
import com.jas.digitalgourmet.controller.dto.RoleDTO;
import com.jas.digitalgourmet.service.RoleService;
import com.jas.digitalgourmet.util.BusinessException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/role")
public class RoleController {
	private RoleService service;
	
	public RoleController(RoleService service) {
		this.service = service;
	}
	
	@GetMapping
	@ApiOperation(value = "Get All Roles", notes = "List of all roles")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful request"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> getAllRoles(@RequestParam(value = "isActive") Boolean isActive) {
		try {
			List<RoleDTO> roleList = service.findAllRoles(isActive);
			return ResponseEntity.ok().body(roleList);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

	@PostMapping
	@ApiOperation(value = "Create Role", notes = "Create Role")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful request"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> saveOrUpdateRole(@RequestBody(required = false) RoleDTO role) {
		try {
			service.saveOrUpdateRole(role);
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
	@ApiOperation(value = "Role Logical Delete", notes = "Delete Role By OID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Saccesfully"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> deleteRoleById(@RequestParam(value = "oid") Long OID) {

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
	@ApiOperation(value = "Get Role By id", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get Roles Saccesfully"),
			@ApiResponse(code = 400, message = "Invalid Request") })
	public ResponseEntity<?> getRoleById(@RequestParam(value = "oid") Long OID) {

		try {
			RoleDTO role = service.getRoleById(OID);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(role);
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ErrorMessageDTO(HttpStatus.UNAUTHORIZED.value(), e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorMessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}

}
