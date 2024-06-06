package com.oderzy.stores_offers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oderzy.helper.CartCodeGenerator;

@Service
public class Coupon_Service {

	@Autowired
	private Coupon_Repositery couponRepo;
	@Autowired
	private CartCodeGenerator cartCodeGenerator;
	@Autowired
	private CouponData cData;


	public List<CouponDTO> gettAllCouponsForUser(String user) {
		LocalDate ld = LocalDate.now().minusDays(1);
		List<CouponDTO> cdt = couponRepo.findByUser(user, ld);

		cdt.forEach(c -> {
			c.setTc(cData.getTc(c.getCode()));
		});
		return cdt;
	}

	public List<CouponDTO> gettAllOffersForUser(String user) {
		List<CouponDTO> cdt = new ArrayList<CouponDTO>();

		cdt.add(new CouponDTO("REF25", "2021-12-31",
				"Order value must be above ₹150 \n Flat ₹25 discount on Net Amount"));
		cdt.add(new CouponDTO("FRESH10", "2021-11-30",
				"No minimum Order value \n Offer applicable only for Fresh Vegeyables \n 10% instant discount on eligible products"));
		cdt.add(new CouponDTO("FRESH5", "2021-04-25",
				"Order value must be above ₹150 \n Flat ₹25 discount on Net Amount"));

		return cdt;
	}

	public List<CouponDTO> gettAllCoupons() {
		return cData.getAllData();
	}

	public List<CouponDTO> getAllForCustomer(String user) {
		// TODO Auto-generated method stub
		return couponRepo.findByCustomer(user);
	}

	public void assignCouponToUser(CouponVO c, Integer days) {
		Coupon coupon = new Coupon(c);
		coupon.expiry = LocalDate.now().plusDays(days);
		coupon.id = cartCodeGenerator.slNo();
		couponRepo.save(coupon);

	}

	public void removeCouponToUser(CouponVO c) {
		Coupon coupon = couponRepo.findTopByUserAndExpiry(c.getUser(), c.getExpiry());
		couponRepo.delete(coupon);
	}

}
