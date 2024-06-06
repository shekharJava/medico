 package com.oderzy.customer.model;

 import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = -5131202589864623163L;
	@Id
	private String custId;
	@Column(unique = true)
	private String mobile;
	private String name;
	private String password;
	private String area;
	@Column(name = "join_date")
	private Date joinDate;
	private String status;
	private String membership;
	private String deviceId;
	private double point;
	
	@OneToOne
	private CustomerAddress customerAddress;
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", mobile=" + mobile + ", name=" + name + ", password=" + password
				+ ", area=" + area + ", joinDate=" + joinDate + ", status=" + status
				+ ", membership=" + membership + ", deviceId=" + deviceId + ", point=" + point + "]";
	}

}
