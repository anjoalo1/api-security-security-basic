package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/message")
public class Message {
	
	private final String message="hola ";
	
	@GetMapping
	public ResponseEntity<?> getMessage(){
		return ResponseEntity.ok(message);
		
	}

}
