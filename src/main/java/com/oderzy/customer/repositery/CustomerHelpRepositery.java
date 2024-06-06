package com.oderzy.customer.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.customer.dto.CustomerHelpDTO;
import com.oderzy.customer.model.CustomerHelp;

public interface CustomerHelpRepositery extends JpaRepository<CustomerHelp, String> {


	List<CustomerHelpDTO> findByStatus(String complaintactive);

	List<CustomerHelpDTO> findByMobileOrderByTime(String mobile);

	CustomerHelp getByHelpIdAndMobile(String helpId, String mobile);

	/* .........................Search Query by input--------------- */


}
