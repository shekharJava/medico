package com.oderzy._security_.oderzy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:papa.properties")
public class TokenGenerator {

	@Autowired
	private Environment env;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public String generateToken(String mobile, String currTime) {
		StringBuilder token = null;

		// adding mobile , current time and the code to
		token = new StringBuilder(currTime);
		token.append(env.getProperty("code"));
		token.append(mobile);
	
		String etoken = passwordEncoder.encode(token);

		return etoken.substring(9, 24);
	}
}
