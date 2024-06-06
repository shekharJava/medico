
package com.oderzy.$config.constants;

import java.time.LocalTime;

public class $Offers {
	private $Offers() {
}
	public static final double freeSlotNetAmount_Kirana = 149;
	public static final double freeSlotNetAmount_Firm = 149;
	public static final LocalTime freeSlotMorning = LocalTime.of(14, 0);
	public static final LocalTime freeSlotEvening = LocalTime.of(22, 0);
	
	public static final LocalTime _9AM = LocalTime.of(9, 0);
	public static final LocalTime _11AM = LocalTime.of(11, 0);
	public static final LocalTime _4PM = LocalTime.of(16, 0);
	public static final LocalTime _8PM = LocalTime.of(20, 0);

	public static final String _MorningDeliveryTIme = "Tomorrow Morning";
	public static final String _EveningDeliveryTIme = "Today evening";
	public static final String _EveningDeliveryTIme_Next = "Tomorrow evening";
	public static final double freeDelivery = 0;

	public static final String _new = "NEW";
	public static final String _hot = "HOT";
public static final String _offer = "OFFER";

}
