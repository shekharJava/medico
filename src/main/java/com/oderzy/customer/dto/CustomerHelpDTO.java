package com.oderzy.customer.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.oderzy.customer.model.CustomerHelp;

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
public class CustomerHelpDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1549445494453505720L;
	protected String helpId;
	protected String mobile;
	protected String name;
	protected String query;
	protected LocalDateTime time;
	protected String status;

	public CustomerHelpDTO(CustomerHelp c) {
		super();
		this.helpId = c.getHelpId();
		this.mobile = c.getMobile();
		this.name = c.getName();
		this.query = c.getQuery();
		this.time = c.getTime();
		this.status = c.getStatus();
	}
	public String getTime() {
		return time.toString().replace("T", " ");
	}

}
