package com.eduit.bootcamp.springbootapi.service;

import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
	
	public static final String ACCESS_TOKEN_HEADER = "access_token";
	public static final String REFRESH_TOKEN_HEADER = "refresh_token";

	Map<String, String> generateTokenSet(final UserDetails user); 
	
	Map<String, String> validateRefreshToken(final String refreshToken);
}
