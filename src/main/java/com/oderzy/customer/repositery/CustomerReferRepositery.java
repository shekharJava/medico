package com.oderzy.customer.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.customer.model.CustomerRefer;

public interface CustomerReferRepositery extends JpaRepository<CustomerRefer, String> {


	List<CustomerRefer> findByReferMobile(String referMobile);


	/* .........................Search Query by input--------------- */


}
