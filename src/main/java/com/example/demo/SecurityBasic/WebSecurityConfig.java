package com.example.demo.SecurityBasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.domain.service.CustomerService;


import jakarta.servlet.Filter;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	 @Autowired
	 private JwtAuthIFilter jwtAuthIFilter;
	 
	
	
	 

	


	@Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		/*
		http
		.authorizeHttpRequests(requests->
		requests
				.requestMatchers("/message", "/customer", "/customer/**", "/swagger-ui.html/**","/swagger-ui/**").permitAll()
				.requestMatchers(HttpMethod.POST, "/customer").permitAll()
			*/	
				
	
		http
		
		.csrf(AbstractHttpConfigurer::disable)
		.addFilterBefore(jwtAuthIFilter, UsernamePasswordAuthenticationFilter.class)
		.authorizeHttpRequests((authorize)->authorize
				 
				
				 //.requestMatchers(new AntPathRequestMatcher("/auth", "POST")).permitAll()
				 //.requestMatchers(new AntPathRequestMatcher("/auth/sing-in", "POST")).permitAll()
				 
		
				 
				 
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/usuarios/**")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/usuarios")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher( "/customer")).hasRole("USER")
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/message")).hasRole("USER")
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/auth")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui.html")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui/**")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui/index.html")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/swagger-ui/index.html/**")).permitAll()
				 .requestMatchers(AntPathRequestMatcher.antMatcher("/v3/**")).permitAll()
				 
				 
				.anyRequest().authenticated()
				);
		 http
	        .formLogin(withDefaults()); // (1)
	    http
	        .httpBasic(withDefaults()); // (1)
	     
	    return http.build();
	}
	
	
	  /*
	  @Bean
	  UserDetailsServiceImplementation userDetailsService() {
	    return new UserDetailsServiceImplementation();
	  }
	  */
	  
	  @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
