package com.oderzy._security_.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserAuth_Services {

	@Autowired
	@Lazy
	private UserLoginService service;

	public boolean hasAccess(String header) {

		return service.isExists(header);
	}
}
