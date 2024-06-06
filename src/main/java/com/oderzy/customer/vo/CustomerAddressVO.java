package com.oderzy.customer.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class CustomerAddressVO {

	protected String mobile;
	protected String phone;
	protected String placeCode;
	protected String houseNo;
	protected String road;
	protected String landmark;
	protected String area;
	protected String city;
	protected int pincode;
	protected String place;

	protected double lat;
	protected double lon;
}

	
	
/*	
 
http://localhost:8080/customer/new/address

{
	"mobile" : "9252",
	"phone" : "9252",
	"placeCode" : "AXBJ+7Q Sambalpur, Odisha",
	"houseNo" : "65",
	"road" : "AN Guha",
	"landmark" : "Samsung Plaz",
	"area" : "Shakipara",
	"city" : "Sambalpur",
	"pincode" : "768001"
}

*/
