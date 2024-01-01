package com.example.demo.SecurityBasic;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.domain.pojo.CustomerPojo;
import com.example.demo.exception.UnauthorizedException;

@Component
public class JwtAuthenticationProvider {
	
	
	private HashMap<String, CustomerPojo> listToken = new HashMap<>();
	
	public String createToken(CustomerPojo customerJwt) {
		
		Date now = new Date();
		Date validity = new Date(now.getTime() + 2600000);
		
		Algorithm algorithm = Algorithm.HMAC256("hola");
		
		String tokenCreated = JWT.create()
				.withClaim("carId", customerJwt.getCardId())
				.withClaim("fullName", customerJwt.getFullName())
				.withClaim("numberCellPhone", customerJwt.getNumberCellPhone())
				.withClaim("email", customerJwt.getEmail())
				.withIssuedAt(now)
				.withExpiresAt(validity)
				.sign(algorithm);
		
		
		listToken.put(tokenCreated, customerJwt);
	
		return tokenCreated;
	}
	
	public Authentication validateToken(String token) throws AuthenticationException{
		
		JWT.require(Algorithm.HMAC256("hola")).build().verify(token);
		
		CustomerPojo exists =listToken.get(token);
		if(exists==null) {
			throw  UnauthorizedException.noAuthorized();
		}
		
		HashSet<SimpleGrantedAuthority> rolesAndAuthorities = new HashSet<>();
		
		rolesAndAuthorities.add(new SimpleGrantedAuthority("ROLE_"+exists.getRol()));
		rolesAndAuthorities.add(new SimpleGrantedAuthority("WRITE_PRIVILEGE"));
	
		return new UsernamePasswordAuthenticationToken(exists, token, rolesAndAuthorities);
		
	}
	
	

}
