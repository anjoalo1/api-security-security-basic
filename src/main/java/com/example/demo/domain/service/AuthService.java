package com.example.demo.domain.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.SecurityBasic.JwtAuthenticationProvider;
import com.example.demo.domain.pojo.AuthPojo;
import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.domain.pojo.JwtPojo;
import com.example.demo.domain.repository.ICustomerRepository;
import com.example.demo.exception.EmailValidationException;

@Service
public class AuthService implements IAuth{
	
	private final ICustomerRepository iCustomerRepository;
	private final JwtAuthenticationProvider jwtAuthenticationProvider;

	
	public AuthService(ICustomerRepository iCustomerRepository, JwtAuthenticationProvider jwtAuthenticationProvider) {
		this.iCustomerRepository = iCustomerRepository;
		this.jwtAuthenticationProvider = jwtAuthenticationProvider;
	}



	@Override
	public JwtPojo signIn(AuthPojo authPojo) {
		// TODO Auto-generated method stub
		 JwtPojo jwtPojo = new JwtPojo("token");
		 
		 
		
		Optional<CustomerPojo> customer = iCustomerRepository.getCustomerByEmail(authPojo.getEmail());
		if(customer.isEmpty()) {
			System.out.println("no se encontro");
			 jwtPojo.setToken("no se encontro");
			 throw EmailValidationException.noFoundEmail();
			 
		}else {
			
			Optional<CustomerPojo> customer2 = iCustomerRepository.getCustomerByEmail(authPojo.getEmail());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(!passwordEncoder.matches(authPojo.getPassword(),customer2.get().getPassword())) {
				 throw EmailValidationException.passwordInvalidate();
			}	
		}
			
			
		return new JwtPojo(jwtAuthenticationProvider.createToken(customer.get()));
		
		
		
		
	}

}
