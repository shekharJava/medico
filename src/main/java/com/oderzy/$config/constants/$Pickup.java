package com.oderzy.$config.constants;

public class $Pickup {
	private $Pickup() {
	}
		
	/* Pickup status at different stages 
	 * 
	 * Order path: REQUESTED ---> ESTIMATED/CANCELLED
	 * 																|
	 * 											ACCEPTED/PENDING
	 * 														|
	 * 													PACKED
	 * 														|
	 * 										SHIPPED  			/ FAILED
	 * 												|
	 * 										DELIVERED
	 * 
	 * */
	
	public static final String _Status_Requested = "Requested";
	public static final String _Status_Estimated = "Estimated";
	public static final String _Status_Pending = "Pending";
	public static final String _Status_Accepted = "Accepted";
	public static final String _Status_Shipped = "Shipped";
	public static final String _Status_Packed = "Packed";
	public static final String _Status_Failed = "Failed";
	public static final String _Status_Delivered = "Delivered";
	public static final String _Status_Cancelled = "Cancelled";

	
	// Delivery Code Chart
	public static final int NormalDelivery = 1;
	public static final int ExpressDelivery = 2;
	public static final int timeSlot = 3;
	public static final int atTime = 4;

	public static final String _normal = "NORMAL";
	public static final String _bhog = "BHOG";
	public static final String _express = "EXPRESS";
	public static final String _care = "CARE";
	public static final String _extraCare = "EXTRA-CARE";
	public static final String _superLock = "Super-LOCK";

	public static final String _offer = "OFFER";
	public static final String _extra = "EXTRA";
	public static final String _special = "SPECIAL";
	public static final String _safe = "SAFE";
	public static final String _heavy = "HEAVY";
	public static final String _large = "LARGE";
	public static final String _unique = "UNIQUE";
	public static final String _rush = "RUSH";

	public static final double offer = 0;
	public static final double extra = 5;
	public static final double special = 10;
	public static final double safe = 15;
	public static final double heavy = 10;
	public static final double large = 10;
	public static final double unique = 15;
	public static final double rush = 15;

	public static final String Normal_0 = "NORMAL-3km";
	public static final String Normal_1 = "NORMAL-5km";
	public static final String Normal_2 = "NORMAL-8km";
	public static final String Exprerss_0 = "EXPRESS-3km";
	public static final String Exprerss_1 = "EXPRESS-5km";
	public static final String Exprerss_2 = "EXPRESS-8km";

	public static final double food_extra = 5;
	public static final double food_Normal_0 = 15;
	public static final double food_Normal_1 = 20;
	public static final double food_Exprerss_0 = 25;
	public static final double food_Exprerss_1 = 30;
	public static final double food_Exprerss_2 = 35;

	public static final double med_Normal_0 = 10;
	public static final double med_Normal_1 = 15;
	public static final double med_Exprerss_0 = 20;
	public static final double med_Exprerss_1 = 20;
	public static final double med_Exprerss_2 = 25;

	public static final double doc_Normal_0 = 12;
	public static final double doc_Normal_1 = 15;
	public static final double doc_Exprerss_0 = 22;
	public static final double doc_Exprerss_1 = 25;
	public static final double doc_Exprerss_2 = 30;
	public static final double doc_care = 10;
	public static final double doc_extraCare = 15;
	public static final double doc_superLock = 50;

	public static final double other_Normal_0 = 10;
	public static final double other_Normal_1 = 15;
	public static final double other_Exprerss_0 = 20;
	public static final double other_Exprerss_1 = 20;
	public static final double other_Exprerss_2 = 25;


	public static final int CustomerOrdersRecord = 5;
	public static final int PartnerOrdersRecord = 20;
	public static final int PartnerActiveOrdersRecord = 20;

}
