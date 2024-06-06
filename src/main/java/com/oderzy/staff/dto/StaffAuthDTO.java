package com.oderzy.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffAuthDTO {

	private String token;
	private String value;
	private String staffId;
	private String mobile;
	private String name;
	private String area;
	private String authority;

	public StaffAuthDTO(String staffId, String mobile, String name, String area) {
		super();
		this.staffId = staffId;
		this.mobile = mobile;
		this.name = name;
		this.area = area;
	}

}
