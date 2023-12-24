package com.example.demo;

import java.security.SecureRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class CursoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoWebApplication.class, args);
		System.out.println("hola mundo");
		
		
		System.out.println(generateRandomPassword(8));
		
		
		
	}
	
	private static String generateRandomPassword(int len) {
		
		final String chars ="AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<len; i++) {
			int randombIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randombIndex));
		}
		
		return sb.toString();
	}

}
