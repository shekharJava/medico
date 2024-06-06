package com.oderzy.stores_offers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Coupon_Repositery extends JpaRepository<Coupon, String> {

	Coupon findTopByCodeAndUser(String code, String User);

	@Query("Select new com.oderzy.stores_offers.CouponDTO(c.code, c.expiry) from Coupon c where c.user = :user And  c.expiry <= :day")
	List<CouponDTO> findByUser(@Param("user") String User, @Param("day") LocalDate day);

	@Query("Select new com.oderzy.stores_offers.CouponDTO(c.code, c.expiry) from Coupon c where c.user = :user")
	List<CouponDTO> findByCustomer(@Param("user") String User);

	Coupon findTopByUserAndExpiry(@Param("user") String User, @Param("day") LocalDate day);

}
