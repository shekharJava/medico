package com.oderzy.staff.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StaffVO  implements Serializable{

	private static final long serialVersionUID = -1044394898405655807L;
	protected String staffId;
	@Column(unique = true)
	protected String mobile;
	protected String secondaryMobile;
	protected String name;
	protected String email;
	protected String password;
	
	@Temporal(TemporalType.DATE)
	protected Date dob;
	protected String line1;
	protected String city;
	protected int pincode;
	protected String area;

	@Column(name = "join_date")
	@Temporal(TemporalType.DATE)
	protected Date joinDate;
	protected String identityType;
	protected String identityProof;
	protected String status;

	protected int hiringManger;
	protected String authority;

	public StaffVO(String mobile, String secondaryMobile, String name, String email, String password, Date dob,
			String line1, String city, int pincode, Date joinDate, String identityType, String identityProof,
			int hiringManger) {
		super();
		this.mobile = mobile;
		this.secondaryMobile = secondaryMobile;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.line1 = line1;
		this.city = city;
		this.pincode = pincode;
		this.joinDate = joinDate;
		this.identityType = identityType;
		this.identityProof = identityProof;
		this.hiringManger = hiringManger;
	}	
	
	
}
