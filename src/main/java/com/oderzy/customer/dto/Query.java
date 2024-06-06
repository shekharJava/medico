package com.oderzy.customer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
public class Query {

	protected String sender;
	protected String message;
	protected boolean appPackageName;
	protected int ruleId;

	public Query(String sender, String message) {
		super();
		this.sender = sender;
		this.message = message;
	}
}