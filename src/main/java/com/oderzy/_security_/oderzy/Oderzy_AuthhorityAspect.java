package com.oderzy._security_.oderzy;

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
import com.oderzy._security_.customer.UserAuth_Services;
import com.oderzy._security_.staff.StaffAuth_Services;

@Component
@Aspect()
public class Oderzy_AuthhorityAspect {
@Lazy
	@Autowired
	private StaffAuth_Services staffAuthService;
@Lazy
	@Autowired
	private UserAuth_Services userAuthService;

	@Before("@annotation(authority)")
	public void validateAspect(JoinPoint jp, OderzyAuth authority) throws Throwable {
		String myheader = null;
		boolean access = false;
		HttpServletRequest req = null;
		req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

		myheader = req.getHeader($Security.userPublic_Token);
		try {
			myheader.length();
			access = userAuthService.hasAccess(myheader);

		} catch (NullPointerException n) {
			myheader = req.getHeader($Security.staffPublic_Token);
			access = staffAuthService.hasAccess(myheader);
}
		// Call your Authorization server and check if all is good

		if (!access)
			throw new UnauthorizedAccessException();

	}

}
