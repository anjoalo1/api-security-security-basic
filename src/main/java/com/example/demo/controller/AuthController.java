package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.pojo.AuthPojo;
import com.example.demo.domain.pojo.JwtPojo;
import com.example.demo.domain.service.AuthService;

@RestController
@RequestMapping(path="/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
	
	private final AuthService authService;
	
	
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}



	@PostMapping(path="/sign-in")
	public ResponseEntity<JwtPojo> sigIn(@RequestBody AuthPojo authPojo){
		
		//return ResponseEntity.status(HttpStatus.OK).body(authPojo);
		return ResponseEntity.status(HttpStatus.OK).body(authService.signIn(authPojo));
		
	}

}
