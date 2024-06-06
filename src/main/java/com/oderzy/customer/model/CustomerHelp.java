package com.oderzy.customer.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.oderzy.customer.dto.CustomerHelpDTO;

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
public class CustomerHelp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549445494453505720L;
	@Id
	protected String helpId;
	protected String mobile;
	protected String name;
	protected String query;
	protected LocalDateTime time;
	protected String status;


	public CustomerHelp(CustomerHelpDTO c) {
		super();
		this.helpId = c.getHelpId();
		this.mobile = c.getMobile();
		this.name = c.getName();
		this.query = c.getQuery();
		//this.time = c.getTime();
		this.status = c.getStatus();
	}

	public static CustomerHelp build(CustomerHelpDTO d) {
		return new CustomerHelp(d);
	}
}
