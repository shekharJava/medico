package com.oderzy.service.general.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralPickupVO {

	// when the pickup to be happen
	// after pickup it will changed to the time delivery boy picked
	protected LocalDateTime pickupTime;
	protected String orderArea;

	// the name and location from where pickup have to be done
	protected String pickupPoint;
	protected String pickupLocation;
	protected String pickupMobile;
	// Medicine, Food, Document,Daily Needs
	protected String pickupType;

	protected String customerMobile;
	protected String customerAddress;
	protected String gps;

	protected String instruction;
	protected String items;
	protected String payment;
	protected double amount;

}
