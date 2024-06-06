package com.oderzy.stores_offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CouponData {
	private Map<String, String> couponTcMap;
	public CouponData() {
		super();
		couponTcMap = new HashMap<String, String>();

		couponTcMap.put("REF25", "Order value must be above ₹150 \n Flat ₹25 discount on Net Amount");
		couponTcMap.put("FRESH10",
				"No minimum Order value \n Offer applicable only for Fresh Vegeyables \n 10% instant discount on eligible products");
		couponTcMap.put("G-FRESH5",
				"No minimum Order value \n Offer applicable only for Fresh Vegeyables \n 5% instant discount on eligible products");

	}
	public 	List<CouponDTO> getAllData(){
		List<CouponDTO> cdt = new ArrayList<>();
		couponTcMap.forEach((k,v)->{
			cdt.add(new CouponDTO(k, v));
		});
		return cdt;
	}
	public String getTc(String code) {
		return couponTcMap.get(code);
	}

}
