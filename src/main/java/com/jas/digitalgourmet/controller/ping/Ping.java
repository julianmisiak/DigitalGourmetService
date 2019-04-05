package com.jas.digitalgourmet.controller.ping;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class Ping {
	@GetMapping
	public ResponseEntity<Date> ping() {
		return new ResponseEntity<>(new Date(), HttpStatus.OK);
	}

}
