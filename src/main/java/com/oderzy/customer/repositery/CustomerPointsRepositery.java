package com.oderzy.customer.repositery;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy.customer.model.CustomerPoints;

public interface CustomerPointsRepositery extends JpaRepository<CustomerPoints, String> {

	@Query(value = "Select p from CustomerPoints p where p.mobile = :mobile  ORDER BY p.date desc")
	List<CustomerPoints> findAllByOrderByMobileAsc(@Param("mobile") String mobile, Pageable pageable);

	/* .........................Search Query by input--------------- */

}
