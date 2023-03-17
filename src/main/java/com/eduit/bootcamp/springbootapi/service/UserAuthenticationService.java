package com.eduit.bootcamp.springbootapi.service;

import java.util.Map;

public interface UserAuthenticationService {
	
	Map<String, String> login(final String username, final String password);
}
