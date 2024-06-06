package com.oderzy.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDTO {

	
	protected String id;
	protected String phone;
	private String placeCode;
	protected String houseNo;
	protected String road;
	protected String landmark;
	protected String area;
	protected String city;
	protected int pincode;

	
}
