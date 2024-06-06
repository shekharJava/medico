package com.oderzy._security_.staff;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Security;
import com.oderzy.$config.constants._Staff;
import com.oderzy._exception_.oderzy.UnauthorizedAccessException;
import com.oderzy._security_.oderzy.AuthData;
import com.oderzy.staff.repositery.StaffRepositery;

@Service
public class StaffLoginService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Lazy
	@Autowired
	private StaffRepositery repo;
	private List<String> signedUser;

	@PostConstruct
	private void initalize() {
		signedUser = new ArrayList<String>();
	}

	public String validate(AuthData data) {
		String token = null;

		ZoneId zoneId = ZoneId.of("Asia/Kolkata");
		LocalDateTime signinTime = LocalDateTime.now(zoneId);

		token = repo.valid(data.getAuthId(), data.getAuthPwd(), _Staff.Status_Active);

		if (token == null)
			throw new UnauthorizedAccessException();

		// generate token and set
		token = generateToken(token, signinTime.toString());
		signedUser.add(token);

		return token;
	}

	public boolean isExists(String id) {
		return signedUser.contains(id);
	}

	public String generateToken(String mobile, String currTime) {
		StringBuilder token = null;
		// adding mobile , current time and the code to
		token = new StringBuilder(currTime);
		token.append($Security._code);
		token.append(mobile);

		String etoken = passwordEncoder.encode(token);

		return etoken.substring(7, 24);
	}

}
