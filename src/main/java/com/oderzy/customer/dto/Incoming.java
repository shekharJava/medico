package com.oderzy.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Incoming {

	protected String appPackageName;
	protected String messengerPackageName;
	protected Query query;
}
