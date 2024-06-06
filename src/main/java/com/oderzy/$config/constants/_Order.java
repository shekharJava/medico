package com.oderzy.$config.constants;

public class _Order {

	private _Order() {
	}
	
	/*
	 * Order status at different stages
	 * 
	 * Order path: PLACED ---> ACCEPTED/PENDING | SHIPPED / FAILED | DELIVERED
	 * 
	 */
	public static final String _Status_Store_Billed = "Pariba_Shakipara";
	public static final String _Status_Store_Failed = "Pariba_Shakipara_Failed";

	public static final String _Status_Placed = "Placed";
	public static final String _Status_Pending = "Pending";
	public static final String _Status_Accepted = "Accepted";
	public static final String _Status_Shipped = "Shipped";
	public static final String _Status_Failed = "Failed";
	public static final String _Status_Delivered = "Delivered";

	
	public static final String _Status_Request= "Requested";
	public static final String _Status_Booked = "Booked";
	public static final String _Status_Completed = "Completed";
	
	public static final String _Status_Scheduled = "Scheduled";

	/*
	 * Pickup status at different stages
	 * 
	 * Order path: REQUESTED ---> ESTIMATED/CANCELLED | ACCEPTED/PENDING | PACKED |
	 * SHIPPED / FAILED | DELIVERED
	 * 
	 */

	public static final String _Status_Requested = "Requested";
	public static final String _Status_Estimated = "Estimated";
	public static final String _Status_Packed = "Packed";
	public static final String _Status_Cancelled = "Cancelled";

	// Cancelled By
	public static final String _Reject_Store = "STORE";
	public static final String _Reject_Staff = "STAFF";
	public static final String _Reject_Boy = "DELIVERY-BOY";
	public static final String _Reject_Packer = "PACKER";

	// payment options
	public static final String _Payment_COD = "COD";
	public static final String _Payment_AGENTUPI = "STAFF_UPI";
	public static final String _Payment_BOYUPI = "BOY_UPI";
	public static final String _Payment_ODERZYUPI = "ODERZY_UPI";

	public static final int CustomerOrdersRecord = 5;
	public static final int PartnerOrdersRecord = 20;
	public static final int PartnerActiveOrdersRecord = 20;

}
