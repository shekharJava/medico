package com.oderzy.pharma.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalBookingVO {

	@NotNull
	protected String storeId;
	protected String user;
	@Pattern(regexp = "^\\d{10}$", message = "Enter 10 digit valid mobile")
	protected String userMobile;
	protected String userAddress;
	protected String usergps;
	protected String deliveryMode;
	


}
