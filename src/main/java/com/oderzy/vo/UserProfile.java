package com.oderzy.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

	public String name;
	public String mobile;
	public String email;
	public String mobileHome;
	public String password;
	public String line1;
	public String city;
	public int pincode;
	public Date dob;
	public String identityType;
	public String identityProof;

	
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfile(String name, String mobile, String email, String mobileHome, String password, String line1,
			String city, int pincode, Date dob, String identityType, String identityProof) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.mobileHome = mobileHome;
		this.password = password;
		this.line1 = line1;
		this.city = city;
		this.pincode = pincode;
		this.dob = dob;
		this.identityType = identityType;
		this.identityProof = identityProof;
	}



	
}
