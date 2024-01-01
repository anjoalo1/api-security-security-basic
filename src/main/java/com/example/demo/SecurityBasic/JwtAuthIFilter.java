package com.example.demo.SecurityBasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.exception.UnauthorizedException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthIFilter extends OncePerRequestFilter {
	
	private final JwtAuthenticationProvider jwtAuthenticationProvider;
	
	

	public JwtAuthIFilter(JwtAuthenticationProvider jwtAuthenticationProvider) {
		this.jwtAuthenticationProvider = jwtAuthenticationProvider;
	}
	


    private List<String> excludeUrlPatterns = new ArrayList<String>(Arrays.asList(
    		"/auth/sign-in","/login","/auth", "/auth/**", "/usuarios", "/usuarios/**",
    		"/swagger-ui.html", "/swagger-ui", "/api-docs", "/v3/**", "/swagger-ui/**"
    		/*"/swagger-ui.html",
    		"/swagger-ui/index.html"*/
    		));
	
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
	  String path = request.getRequestURI();
	        if (excludeUrlPatterns.contains(path)) {
	            return true;
	        } else {
	            return false;
	        }
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(header == null) {
			throw  UnauthorizedException.noAuthorized();
		}
		String[] authElements = header.split(" ");
		
		if (authElements.length != 2 || !"Bearer".equals(authElements[0])) {
			throw  UnauthorizedException.noAuthorized();
		}
		
		try {
			Authentication auth = (Authentication) jwtAuthenticationProvider.validateToken(authElements[1]);
			SecurityContextHolder.getContext().setAuthentication(auth);
		}catch(RuntimeException e) {
			System.out.println(e);
			SecurityContextHolder.clearContext();
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
	
	
	
	
	
	



	
}
