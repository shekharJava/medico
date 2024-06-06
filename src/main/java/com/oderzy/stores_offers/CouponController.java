package com.oderzy.stores_offers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;

@RestController
@RequestMapping(value = $Navigation._Coupon_controller)
@CrossOrigin()
public class CouponController {

	@Autowired
	private Coupon_Service service;

	/*
	 * ------------------------------>Get Request Agent
	 */

	@GetMapping("/all")
	// @StaffAuth()
	public List<CouponDTO> getAllCoupon() {

		return service.gettAllCoupons();
	}

	@GetMapping("/all/{user}")
	public List<CouponDTO> getAllCouponForCustomer(@PathVariable String user) {
		return service.gettAllOffersForUser(user);
	}

	@GetMapping("/all-coupons/{user}")
	public List<CouponDTO> getAllCouponCustomer(@PathVariable String user) {
		return service.getAllForCustomer(user);
	}

	
	/*
	 * ------------------------------>Post Request
	 */
	@PutMapping("/assign/{days}")
	public void assignCoupon(@RequestBody CouponVO coupon, @PathVariable Integer days) {
		service.assignCouponToUser(coupon, days);
	}

	@PutMapping("/remove")
	public void removeCoupon(@RequestBody CouponVO coupon) {
		service.removeCouponToUser(coupon);
	}
}
