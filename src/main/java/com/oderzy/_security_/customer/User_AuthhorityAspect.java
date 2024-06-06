package com.oderzy._security_.customer;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.oderzy.$config.constants.$Security;
import com.oderzy._exception_.oderzy.UnauthorizedAccessException;

@Component
@Aspect()
public class User_AuthhorityAspect {

	@Autowired
	private UserAuth_Services authService;

	@Before("@annotation(authority)")
	public void validateAspect(JoinPoint jp, UserAuth authority) throws Throwable {
		String myheader = null;
		boolean access = false;
		HttpServletRequest req = null;

		req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		myheader = req.getHeader($Security.user_Token);

		// Call your Authorization server and check if all is good
		access = authService.hasAccess(myheader);

		if (!access)
			throw new UnauthorizedAccessException();

	}

}
