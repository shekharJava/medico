package com.oderzy._notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordCall {

	private String mobile;
	private String appType;
	private String deviceId;
	private String otp;
	
}
