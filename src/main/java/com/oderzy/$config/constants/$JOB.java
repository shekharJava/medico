package com.oderzy.$config.constants;

public class $JOB {
private $JOB() {
	// TODO Auto-generated constructor stub
}
	/* Order status at different stages */
	public static final String _Status_New = "NEW";
	public static final String _Status_Working = "WORKING";
	public static final String _Status_Closed = "CLOSED";
	public static final String _Status_Rejected = "REJECTED";
	public static final String _Status_Warn = "STOP";

	
	//job type
	public static final String _CALLER = "CALLER";
	public static final String _Packer = "PACKER";
	public static final String _Shipper = "DELIVERY-BOY";
	public static final String _Packer_Store = "Store-Staff";

	
	
	public static final int MaxJob = 3;


}
