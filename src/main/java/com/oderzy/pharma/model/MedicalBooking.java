package com.oderzy.pharma.model;

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
public class MedicalBooking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8288956060783172723L;

	@Id
	private String bookingId;
	private String mobile;
	private String storeId;
	private String area;
	private String address;
	private String gps;
	private double itemsPrice;
	private double serviceCharge;
	private String storename;
	private String status;
	private String user;
	private String userMobile;
	private String userAddress;
	private String usergps;
	private LocalDateTime orderTime;
	private LocalDateTime deliveryTime;

}
