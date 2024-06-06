package com.oderzy.pharma.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;

import com.oderzy.pharma.model.MedicalBooking;

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
public class MedicalBookingDTO {

	@Id
	protected String bookingId;

	protected String mobile;

	protected String storeId;

	protected String area;

	protected String address;

	protected String gps;

	private double itemsPrice;

	private double serviceCharge;

	protected String name;

	protected String status;

	protected String user;

	protected String userMobile;

	protected String userAddress;
	protected String usergps;
	protected LocalDateTime orderTime;
	protected LocalDateTime deliveryTime;

	public MedicalBookingDTO(MedicalBooking m) {
		super();
		this.bookingId = m.getBookingId();
		this.mobile = m.getMobile();
		this.storeId = m.getStoreId();
		this.area = m.getArea();
		this.address = m.getAddress();
		this.gps = m.getGps();
		this.itemsPrice = m.getItemsPrice();
		this.serviceCharge = m.getServiceCharge();
		this.name = m.getStorename();
		this.status = m.getStatus();
		this.user = m.getUser();
		this.userMobile = m.getUserMobile();
		this.userAddress = m.getUserAddress();
		this.usergps = m.getUsergps();
		this.orderTime = m.getOrderTime();
		this.deliveryTime = m.getDeliveryTime();
	}

}
