package com.oderzy.stores_order.delivery.service;

import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Customer;
import com.oderzy.$config.constants.$Delivery;

@Service
public class DeliveryCalculator {

	public double getDeliveryFeeInner_(double profit) {
		if (profit < 40) {
			if (profit <= 20)
				return 29;
			else
				return 12;
		} else
			return 0;
	}

	public double getDeliveryFeeInner(String city, double profit) {
		if (profit <= 50) {

			if (profit <= 18)
				return 24;

			if (profit <= 24)
				return 10;
			if (profit <= 50)
				return 8;
			else
				return $Delivery._normalFree;
		} else
			return $Delivery._normalFree;
	}

	public double getDeliveryFeeCenter(double net, double profit) {
		if (profit <= 30) {

			if (profit <= 10)
				return 19;
			if (profit <= 16)
				return 10;
			if (profit <= 21)
				return 5;
			else
				return $Delivery._normalFree;

		} else
			return $Delivery._normalFree;

	}

	public double getDeliveryFeeOuter(String city, double profit) {
		if (profit <= 80) {

			if (profit <= 10)
				return 75;
			if (profit <= 15)
				return 65;
			if (profit <= 25)
				return 55;
			if (profit <= 35)
				return 45;
			if (profit <= 50)
				return 35;
			if (profit <= 60)
				return 20;
			if (profit <= 70)
				return 10;
			else
				return $Delivery._normalFree;

		} else
			return $Delivery._normalFree;

	}

	public double getDeliveryFee2(String promo, double profit) {
		if (profit <= 30) {

			if (promo.equals($Customer.$goldMembership)) {
				if (profit <= 10)
					return $Delivery._normalFeeLow;
				if (profit <= 20)
					return $Delivery._normalFeeLow_Silver;
				else
					return $Delivery._normalFree;
			} else if (promo.equals($Customer.$newMembership)) {
				if (profit <= 15)
					return $Delivery._surchargeFeeHIgh;
				else
					return $Delivery._normalFeeLow;
			} else {
				if (profit <= 10)
					return $Delivery._normalFeeHIgh;
				if (profit <= 15)
					return $Delivery._normalFeeLow;
				if (profit <= 25)
					return $Delivery._normalFeeLow_Silver;
				else
					return $Delivery._normalFree;

			}
		} else
			return $Delivery._normalFree;

	}
}
