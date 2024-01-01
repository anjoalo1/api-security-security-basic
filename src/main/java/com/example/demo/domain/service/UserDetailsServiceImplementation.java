/*
package com.example.demo.domain.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.domain.pojo.CustomerPojo;

public class UserDetailsServiceImplementation  implements UserDetailsService  {
	

	private final CustomerService customerService=null;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		return User.withUsername("carlos")
		        .password("$2a$10$c2dxTKPqhiq7b8phZOo75.uYSGjMO3lvHfvQkBxzVM/9VUa0xItHC")
		        .roles("USER")
		        .build();
	}
		
}

*/