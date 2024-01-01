package com.example.demo.domain.service;

import com.example.demo.domain.pojo.AuthPojo;
import com.example.demo.domain.pojo.JwtPojo;

public interface IAuth {
	
	JwtPojo signIn(AuthPojo authPojo);
}
