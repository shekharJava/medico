package com.oderzy.customer.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomerVO {

	protected String mobile;
	protected String name;
	protected String password;
	protected double lat;
	protected double lon;
	protected String houseNo;
	protected String road;
	protected String landmark;
	protected String city;
	protected String refer;
	@Override
	public String toString() {
		return "NewCustomerVO [mobile=" + mobile + ", name=" + name + ", password=" + password + ", lat=" + lat
				+ ", lon=" + lon + ", houseNo=" + houseNo + ", road=" + road + ", landmark=" + landmark + ", city="
				+ city + ", refer=" + refer + "]";
	}
	
	
}