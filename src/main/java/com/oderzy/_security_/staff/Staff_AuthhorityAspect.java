package com.oderzy._security_.staff;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.oderzy.$config.constants.$Security;
import com.oderzy._exception_.oderzy.UnauthorizedAccessException;

@Component
@Aspect()
public class Staff_AuthhorityAspect {

	@Lazy
	@Autowired
	private StaffAuth_Services authService;

	@Before("@annotation(authority)")
	public void validateAspect(JoinPoint jp, StaffAuth authority) throws Throwable {
		String myheader = null;
		boolean access = false;
		HttpServletRequest req = null;
		try {
			req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			myheader = req.getHeader($Security.staff_Token);

		} catch (NullPointerException e) {
		}

		// Call your Authorization server and check if all is good
		access = authService.hasAccess(myheader);

		if (!access)
			throw new UnauthorizedAccessException();

	}

}
