package com.oderzy.stores_offers;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDTO {

	private String code;
	private String expiry;

	private String tc;

	public CouponDTO(String code, LocalDate expiry) {
		super();
		this.code = code;
		this.expiry = expiry.toString().replace("T", " ");
	}
	
	public CouponDTO(String code, String tc) {
		super();
		this.code = code;
		this.tc = tc;
	}
	
	
}
