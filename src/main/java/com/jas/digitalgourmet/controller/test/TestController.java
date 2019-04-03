package com.jas.digitalgourmet.controller.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jas.digitalgourmet.controller.valueobject.TestVO;
import com.jas.digitalgourmet.model.Test;
import com.jas.digitalgourmet.service.TestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/test")
public class TestController {
	private TestService service;

	public TestController(TestService service) {
		this.service = service;
	}

	@PostMapping
	@ApiOperation(value = "Test", notes = "Servicio de Test")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Test creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Inválida") })
	public ResponseEntity<Test> createCliente(@RequestBody TestVO testVO) {
		Test test = new Test();
		return new ResponseEntity<>(this.service.create(test), HttpStatus.CREATED);
	}
}
