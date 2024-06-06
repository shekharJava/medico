package com.oderzy._security_.oderzy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthData {

	private String authId;
	private String authPwd;
	
	@Override
	public String toString() {
		return "AuthsData [authId=" + authId + ", authPwd=" + authPwd + "]";
	}
	
}
