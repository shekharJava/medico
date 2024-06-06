package com.oderzy.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfileDTO {

	protected String mobile;
	protected String name;
	protected String phone;

	private String placeCode;
	protected String houseNo;
	protected String road;
	protected String landmark;
	protected String area;
	

	public CustomerProfileDTO(String phone, String placeCode, String houseNo, String road, String landmark, String area) {
		super();
		this.phone = phone;
		this.placeCode = placeCode;
		this.houseNo = houseNo;
		this.road = road;
		this.landmark = landmark;
		this.area = area;
		
	}

}
