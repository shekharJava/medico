package com.oderzy.staff.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;
import com.oderzy.$config.constants.$Security;
import com.oderzy.$config.constants._Oderzy;
import com.oderzy.$config.constants._Staff;
import com.oderzy._notification.service.StaffNotificationService;
import com.oderzy._security_.oderzy.AuthData;
import com.oderzy._security_.oderzy.AuthToken;
import com.oderzy._security_.staff.StaffAuthority;
import com.oderzy._security_.staff.StaffLoginService;
import com.oderzy.staff.dto.StaffAuthDTO;
import com.oderzy.staff.dto.StaffDTO;
import com.oderzy.staff.dto.StaffProfileDTO;
import com.oderzy.staff.dto.StaffVO;
import com.oderzy.staff.model.Staff;
import com.oderzy.staff.service.StaffService;
import com.oderzy.vo.UserProfile;

@RestController
@CrossOrigin
@RequestMapping(value = $Navigation._Staff_controller)
public class StaffController {

	@Autowired
	private StaffService service;
	@Autowired
	private StaffLoginService loginService;
	@Autowired
	private StaffNotificationService staffNotificationService;

	
	// Get deviceId for notifiaction
	@GetMapping("/notifications/{mobile}/{deviceId}")
	public List<String> notification(@PathVariable String mobile, @PathVariable String deviceId) {
		// loading user device for notification
		staffNotificationService.addDevice(mobile, deviceId);

		List<String> l = new ArrayList<>();
		l.add("https://oderzy-datas.s3.ap-south-1.amazonaws.com/banner/FRESH+TO+HOME+PNG.png");
		l.add("https://oderzy-datas.s3.ap-south-1.amazonaws.com/banner/coffee.png");
		l.add("https://oderzy-datas.s3.ap-south-1.amazonaws.com/banner/dishwash.png");
		l.add("https://oderzy-datas.s3.ap-south-1.amazonaws.com/banner/fresh+fruits.png");

		return l;
	}



	@GetMapping("/profile/id/{staffId}")
	@StaffAuthority(roles = { _Staff.role0S, _Oderzy.role0M })
	public StaffDTO profileByStaffId(@PathVariable int staffId) {
		return service.profileByStaffId(staffId);
	}

	@GetMapping("/profile/complete/mobile/{mobile}")
	@StaffAuthority(roles = { _Staff.role0S, _Oderzy.role0M })
	public StaffProfileDTO profileByMobileComplete(@PathVariable String mobile) {
		return service.profileByMobileComplete(mobile);
	}

	@GetMapping("/profile/mobile/{mobile}")
	@StaffAuthority(roles = { _Staff.role0S, _Oderzy.role0M, _Oderzy.role0A, _Oderzy.role0CS })
	public StaffDTO profileByMobile(@PathVariable String mobile) {
		return service.profileByMobile(mobile);
	}

	@GetMapping("/profile/secondaryMobile/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public StaffDTO profileBySecondaryMobile(@PathVariable String mobile) {
		return service.profileBySecondaryMobile(mobile);
	}

	@GetMapping("/profiles/name/{name}")
	@StaffAuthority(roles = { _Staff.role0S, _Oderzy.role0M, _Oderzy.role0A, _Oderzy.role0CS })
	public List<StaffDTO> profilesByName(@PathVariable String name) {
		return service.profilesByName(name);
	}

	@GetMapping("/profiles/city/{city}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public List<StaffDTO> profilesByCity(@PathVariable String city) {
		return service.profilesByCity(city);
	}

	@GetMapping("/profiles/join/{joinDate}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public List<StaffDTO> profilesByJoinDate(Date joinDate) {
		return service.profilesByJoinDate(joinDate);
	}

	@GetMapping("/sort/profiles/joinDate")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public List<StaffDTO> sortProfilesByJoinDate() {
		return service.sortProfilesByJoinDate();
	}

	/*-----------------Updation Query-------------------*/

	@PostMapping("/authenticate/{deviceId}")
	public StaffAuthDTO authenticate(@RequestBody AuthData data, @PathVariable String deviceId) {
		StaffAuthDTO authToken = new StaffAuthDTO();
		authToken.setValue(loginService.validate(data));
		authToken.setToken($Security.staff_Token);
		staffNotificationService.addDevice(data.getAuthId(), deviceId);
		StaffDTO sd = service.profileByMobile(data.getAuthId());
		authToken.setArea(sd.getArea());
		authToken.setName(sd.getName());
		authToken.setStaffId(sd.getStaffId());
		authToken.setMobile(data.getAuthId());
		return authToken;

	}
	@PostMapping("/boy-login")
	public StaffDTO boyLogin(@RequestBody AuthData data) {
		loginService.validate(data);
		return service.profileByMobile(data.getAuthId());
	
	}
	@PostMapping("/login")
	public AuthToken login(@RequestBody AuthData data, HttpServletResponse response) {
		AuthToken authToken = new AuthToken();
		authToken.setValue(loginService.validate(data));
		authToken.setToken($Security.staff_Token);
		return authToken;

	}

	

	@PostMapping("/register/{manager}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public Staff registerNewStaff(@RequestBody UserProfile profile, @PathVariable int manager) {
		return service.registerNewStaff(profile, manager);
	}

	@PostMapping("/register")
	public Staff add(@RequestBody StaffVO staff) {
		return service.add(staff);
	}

	@PutMapping("/update/mobile/{newmobile}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateMobile(@PathVariable String newmobile, @PathVariable String mobile) {
		return service.updateMobile(newmobile, mobile);
	}

	@PutMapping("/update/email/{email}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateEmail(@PathVariable String email, @PathVariable String mobile) {
		return service.updateEmail(email, mobile);
	}

	@PutMapping("/update/secondary_mobile/{newmobile}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateSecondaryMobile(@PathVariable String newmobile, @PathVariable String mobile) {
		return service.updateSecondaryMobile(newmobile, mobile);
	}

	@PutMapping("/update/name/{name}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateName(@PathVariable String name, @PathVariable String mobile) {
		return service.updateName(name, mobile);
	}

	@PutMapping("/update/dob/{dob}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateDOB(Date dob, @PathVariable String mobile) {
		return service.updateDOB(dob, mobile);
	}

	@PutMapping("/update/password/{password}/{mobile}/{otp}")
	public int updatePassword(@PathVariable String mobile, @PathVariable String password, @PathVariable String otp) {
		return service.updatePassword(mobile, password, otp);
	}

	@PostMapping("/update-req/password/{deviceid}/{mobile}/{appType}")
	public void updateRequestPassword(@PathVariable String mobile, @PathVariable String deviceid,
			@PathVariable String appType) {
		service.updatePassword(mobile, deviceid, appType);
	}

	@PutMapping("/update/identity/{type}/{id}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateIdentity(@PathVariable String type, @PathVariable String id, @PathVariable String mobile) {
		return service.updateIdentity(type, id, mobile);
	}

	@PutMapping("/update/address/{line1}/{city}/{pincode}/{mobile}")
	@StaffAuthority(roles = { _Oderzy.role0M })
	public int updateAddress(@PathVariable String line1, @PathVariable String city, @PathVariable int pincode,
			@PathVariable String mobile) {
		return service.updateAddress(line1, city, pincode, mobile);
	}
}
