package com.oderzy.stores_offers;

import java.io.Serializable;
import java.time.LocalDate;

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
public class Coupon implements Serializable {

	private static final long serialVersionUID = -6947856852011585266L;
	@Id
	protected int id;
	protected String code;
	protected LocalDate expiry;
	protected String user;

	public Coupon(CouponVO c) {
		this.id = c.getId();
		this.code = c.getCode();
		this.expiry = c.getExpiry();
		this.user = c.getUser();
	}

}
