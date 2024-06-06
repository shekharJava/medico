package com.oderzy.stores_offers;

import java.io.Serializable;
import java.time.LocalDate;

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
public class CouponVO implements Serializable {

	private static final long serialVersionUID = -6947856852011585266L;
	protected int id;
	protected String code;
	protected LocalDate expiry;
	protected String user;
}
