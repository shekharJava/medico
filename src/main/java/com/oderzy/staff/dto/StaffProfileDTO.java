package com.oderzy.staff.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffProfileDTO {

	private String staffId;
	private String mobile;
	private String secondaryMobile;
	private String name;
	private String email;
	private Date dob;
	private String line1;
	private String city;
	private int pincode;

	private Date joinDate;
	private String identityType;
	private String identityProof;

	private int hiringManger;

	
	
}
