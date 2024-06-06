package com.oderzy._security_.oderzy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthToken {

	private String token;
	private String value;
	
	@Override
	public String toString() {
		return "AuthToken [token=" + token + ", value=" + value + "]";
	}
	
}
