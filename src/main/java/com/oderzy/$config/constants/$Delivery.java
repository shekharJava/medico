package com.oderzy.$config.constants;

import java.time.LocalTime;

public class $Delivery {
	private $Delivery() {
		super();
	}
	public static final String _normal = "NORMAL";
	public static final String _express = "EXPRESS";

	public static final double _normalFree = 0;
	public static final double _normalFeeLow_Silver = 10;
	public static final double _normalFeeLow = 15;
	public static final double _normalFeeHIgh = 20;
	public static final double _surchargeFeeHIgh = 28;
	public static final double _expressFee = 35;
	public static final String _ExpressDeliveryTIme = "ExpressDelivery";

	// public static final LocalTime _10AM = LocalTime.of(9, 0);
	public static final LocalTime _11AM = LocalTime.of(4, 20);
	public static final LocalTime _10AM = LocalTime.of(4, 0);
	// public static final LocalTime _4PM = LocalTime.of(16, 30);
	public static final LocalTime _8PM = LocalTime.of(14, 30);
	public static final LocalTime _12AM = LocalTime.of(18, 30);

	public static final LocalTime _830AM = LocalTime.of(3, 30);
	public static final LocalTime _7AM = LocalTime.of(1, 30);

	/*
	 * public static final String today_9AM = "Today \n8 AM - 11 AM"; public static
	 * final String today_11AM = "Today \n11 AM - 2 PM"; public static final String
	 * today_4PM = "Today \n5 PM - 8 PM"; public static final String today_8PM =
	 * "Today \n7 PM - 9:30 PM"; public static final String tommorow_9AM =
	 * "Tommorow \n8 AM - 11 AM"; public static final String tommorow_11AM =
	 * "Tommorow \n11 AM - 2 PM"; public static final String tommorow_4PM =
	 * "Tommorow \n5 PM - 8 PM"; public static final String tommorow_8PM =
	 * "Tommorow \n7 PM - 9:30 PM";
	 */
	public static final String today_MRNG = "Morning Delivery";
	public static final String today_NRML = "Normal Delivery";
	public static final String tommorow_NRML = "Tommorow \nMorning Delivery";
	public static final String tommorow_MRNG = "Tommorow \nNormal Delivery";

	public static final String today_9AM = "Morning Delivery";
	public static final String today_11AM = "Normal Delivery";
	public static final String today_4PM = "Normal Delivery";
	public static final String today_8PM = "Normal Delivery";
	public static final String tommorow_9AM = "Tommorow \nMorning Delivery";
	public static final String tommorow_11AM = "Tommorow \nNormal Delivery";
	public static final String tommorow_4PM = "Tommorow \nNormal Delivery";
	public static final String tommorow_8PM = "Tommorow \nNormal Delivery";
	// Delivery Code Chart
	public static final int NormalDelivery = 1;
	public static final int ExpressDelivery = 2;

	public static final int FreeDelivery = 0;

	public static final int free_MRNGSlot_ = 98;
	public static final int free_EVNGSlot_ = 99;

	// Delivery zones NetAmount
	public static final int Zone_0 = 100;
	public static final int Zone_1 = 150;
	public static final int Zone_2 = 200;
	public static final int Zone_3 = 300;
	// Delivery zones Delivery Fee
	public static final int Zone_0_Delivery = 10;
	public static final int Zone_1_Delivery = 15;
	public static final int Zone_2_Delivery = 15;
	public static final int Zone_3_Delivery = 25;

	// Delivery fee for addOns which are not include in our services
	public static final int Zone_0_addOnDelivery = 15;
	public static final int Zone_1_addOnDelivery = 15;
	public static final int Zone_2_addOnDelivery = 20;
	public static final int Zone_3_addOnDelivery = 30;

	// Pick up Drop
	public static final int _3KmRange = 15;
	public static final int _5KmRange = 20;
	public static final int _7KmRange = 25;
	public static final int _10KmRange = 30;

	// Delivery Fee Chart

	public static final double Vegetable_NormalDeliveryFee = 15;
	public static final double Vegetable_ExpressDeliveryFee = 25;
	public static final double Vegetable_FreeDelivery = 0;

	public static final double Fruit_NormalDeliveryFee = 10;
	public static final double Fruit_ExpressDeliveryFee = 15;
	public static final double Fruit_FreeDelivery = 0;

	public static final double Food_FreeDelivery = 0;
	public static final double Food_DeliveryFee = 10;
	public static final double Food_LowDeliveryFee = 15;

	public static final double Kirana_NormalDeliveryFee = 10;
	public static final double Kirana_ExpressDeliveryFee = 20;
	public static final double Kirana_FreeDelivery = 0;

	// item must be carriable in a bagpack / qty must not exceed 10 /weight must be
	// within 12 kg

	public static final double General_NormalDeliveryFee = 10;
	public static final double General_ExpressDeliveryFee = 20;
	public static final double General_FreeDelivery = 0;

	// Heavy weight/ large size orders
	public static final double GeneralDeliveryFee_above12kg = 20;
	public static final double GeneralDeliveryFee_above25kg = 39;
	public static final double GeneralDeliveryFee_above50kg = 69;
	public static final double GeneralDeliveryFee_above100kg = 100;
	public static final double GeneralDeliveryFee_above100kg_per10kg = 5;

	// Delivery Time chart as per delivery fee and item type

	public static final String Vegetable_NormalDeliveryTIme = "Normal Delivery";
	public static final String Vegetable_ExpressDeliveryTIme = "Express Delivery";
	public static final String Vegetable_MorningDeliveryTIme = "Tomorrow Morning";
	public static final String Vegetable_EveningDeliveryTIme = "Today evening";

	public static final String Food_ExpressDeliveryTime = "Fast Delivery";
	public static final String Food_NormalDeliveryTime = "Normal Delivery";

	public static final String Kirana_NormalDeliveryTIme = "Normal Delivery";
	public static final String Kirana_ExpressDeliveryTIme = "Express Delivery";
	public static final String Kirana_MorningDeliveryTIme = "Tomorrow Morning";
	public static final String Kirana_EveningDeliveryTIme = "Today evening";

	// item must be carriable in a bagpack / qty must not exceed 10 /weight must be
	// within 12 kg
	public static final String General_NormalDeliveryTIme = "Normal Delivery";
	public static final String General_ExpressDeliveryTIme = "Express Delivery";
	public static final String General_ComboDeliveryTIme = "Combo Order Delay Delivery";
	public static final String General_ComboDeliveryExpressTIme = "Combo Order Fast Delivery";
	public static final String General_BulkDeliveryTIme = "BulkOrder delay Delivery";

}
