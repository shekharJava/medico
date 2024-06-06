package com.oderzy._security_.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class StaffAuth_Services {

	@Lazy
@Autowired
	private StaffLoginService service;

	public boolean hasAccess(String header) {

		return service.isExists(header);
	}
}
