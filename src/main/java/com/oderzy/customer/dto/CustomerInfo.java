package com.oderzy.customer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInfo {

	private String mobile;
	private String name;
	private String address;
	private String area;
	private String city;
	private String membership;
	private double lat;
	private double lon;

	public CustomerInfo(String mobile, String name, String houseNo, String road, String area, String areaCode,
			String landmark, String city, String phone, String membership) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.address = this.address(houseNo, road, area, landmark, city, phone);
		this.city = city;
		this.area = areaCode;
		this.membership = membership;
	}

	private String address(String houseNo, String road, String area, String landmark, String city, String phone) {
		String s = "";
		try {
			s = new StringBuffer(houseNo).append(" ").append(road).append(" ").append(landmark).append(", ")
					.append(city).append("\n ").append(phone).toString();
		} catch (NullPointerException e) {
			s = city + "\n" + mobile;
		}
		return s;
	}

	public CustomerInfo(String mobile, String name, String area) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.area = area;
	}

}
