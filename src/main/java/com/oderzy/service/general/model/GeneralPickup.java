package com.oderzy.service.general.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GeneralPickup implements Serializable {

	private static final long serialVersionUID = -2471331025516301925L;
	@Id
	protected String serviceCode;
	// when the oprder is being placed
	protected LocalDateTime orderTime;
	// when the order delivered ......
	protected LocalDateTime deliveryTime;
	// when the pickup to be happen
	// after pickup it will changed to the time delivery boy picked
	protected LocalDateTime pickupTime;

	/*
	 * order Status --------->Placed /--------->Proposed ---------->Confirmed
	 * -------------->Approved /--------->Shipped/ ---------->Delivered/
	 * ---------->Cancelled/ ----------->Failed
	 */
	protected String status;

	// The Delivery agent mobile who will delivery the order
	protected String deliveryAgentMobile;
	// the name and location from where pickup have to be done
	protected String pickupPoint;
	protected String pickupLocation;
	protected String pickupMobile;

	// Bhog, Medicine, Food, Document,Daily Needs
	protected String pickupType;
	private double itemTotal;
	private double serviceCharge;
	private double netAmount;

	protected String customerMobile;
	protected String customerAddress;
	protected String customerGps;

	protected String items;
	/*
	 * --------->COD/ --------->Oderzy UPI/ --------->Agent UPI/ --------->Boy UPI
	 */
	protected String paymentMethod;
	protected String instruction;

	public GeneralPickup(String serviceCode, LocalDateTime orderTime, LocalDateTime pickupTime, String status,
			String pickupPoint, String pickupMobile, String pickupType, double itemTotal, double serviceCharge,
			double netAmount, String customerMobile, String customerAddress, String customerGps, String items,
			String paymentMethod, String instruction) {
		super();
		this.serviceCode = serviceCode;
		this.orderTime = orderTime;
		this.pickupTime = pickupTime;
		this.status = status;
		this.pickupPoint = pickupPoint;
		this.pickupMobile = pickupMobile;
		this.pickupType = pickupType;
		this.itemTotal = itemTotal;
		this.serviceCharge = serviceCharge;
		this.netAmount = netAmount;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerGps = customerGps;
		this.items = items;
		this.paymentMethod = paymentMethod;
		this.instruction = instruction;
	}

	public GeneralPickup(GeneralPickupDTO d) {
		super();
		this.serviceCode = d.getServiceCode();
		this.orderTime = d.getOrderTime();
		this.pickupTime = d.getPickupTime();
		this.status = d.getStatus();
		this.pickupPoint = d.getPickupPoint();
		this.pickupMobile = d.getPickupMobile();
		this.pickupType = d.getPickupType();
		this.itemTotal = d.getItemTotal();
		this.serviceCharge = d.getServiceCharge();
		this.netAmount = d.getNetAmount();
		this.customerMobile = d.getCustomerMobile();
		this.customerAddress = d.getCustomerAddress();
		this.customerGps = d.getCustomerGps();
		this.items = d.getItems();
		this.paymentMethod = d.getPaymentMethod();
		this.instruction = d.getInstruction();
	}

}
