package com.oderzy.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CustomerAddress implements Serializable {

	private static final long serialVersionUID = -8473423493451569470L;

	@Id
	private String id;

	@OneToOne(mappedBy = "customerAddress")
	private Customer user;

	private String phone;
	private String placeCode;
	private double lattitude;
	private double longitude;

	private String houseNo;
	private String road;
	private String landmark;
	private String area;
	private String city;
	private int pincode;

	public CustomerAddress(Customer user, String id, String phone, String houseNo, String road, String landmark,
			String area, String city, int pincode) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.houseNo = houseNo;
		this.road = road;
		this.landmark = landmark;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

	public CustomerAddress(String area2, String city2, String string, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public CustomerAddress(Customer user, String id, String phone, String area, String city, int pincode) {
		super();
		this.id = id;
		this.user = user;
		this.phone = phone;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}

}
