package com.oderzy.$config.constants;

public class _Call {


	private _Call() {
		super();
	}
	public static final String roleOs = "Staff";

	public static final String CallReceived = "NEW";
	public static final String CallNoResponse = "NORESPONSE";

	public static final String CallConnect = "CONNECTED";
	public static final String CallFailed = "FAILED";
	public static final String CallComplete = "CLOSED";
	
	
	
	public static final int NonRespondedCallTime = 3000000;
	public static final int MissedCallRecord = 5;

}
