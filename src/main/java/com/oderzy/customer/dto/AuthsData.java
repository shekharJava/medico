package com.oderzy.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthsData {

//0 new user send for signup
//1 User Exists match login

	protected int action;
	//0 update optional
	//1 update mandatory
	//5 updated versio9
	protected int update;
	protected String pass;
}
