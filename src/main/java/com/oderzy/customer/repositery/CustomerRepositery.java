package com.oderzy.customer.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oderzy.customer.dto.CustomerDTO;
import com.oderzy.customer.dto.CustomerInfo;
import com.oderzy.customer.model.Customer;
import com.oderzy.customer.model.query.CustomerQuery;

public interface CustomerRepositery extends JpaRepository<Customer, String> {

	/* .........................Search Query by input--------------- */

	Customer findByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerQuery.allMobile)
	List<String> getAllUserMobile(@Param("status") String status);

	@Query(value = CustomerQuery.authenticate)
	String getPassForUser(@Param("mobile") String mobile,@Param("status") String status);

	@Query(value = CustomerQuery.validate)
	String valid(@Param("mobile") String mobile, @Param("pwd") String pwd, @Param("status") String status);

	@Query(value = CustomerQuery.validate1)
	String valid(@Param("mobile") String mobile, @Param("status") String status);

	@Query(value = CustomerQuery.getAreaByMobile)
	String getAreaByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerQuery.getDeviceByMobile)
	String getDeviceByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerQuery.getNameByMobile)
	String getNameByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerQuery.getCustomerInfoByMobile)
	CustomerInfo getCustomerInfoByMobile(@Param("mobile") String mobile, @Param("status") String status);

	@Query(value = CustomerQuery.getByMobile)
	CustomerDTO getByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerQuery.getByCustId)
	CustomerDTO getByCustId(@Param("custId") String custId);

	
	@Query(value = CustomerQuery.getByArea)
	List<CustomerDTO> getByArea(@Param("area") String area);

	@Query(value = CustomerQuery.getByjoinDate)
	List<CustomerDTO> getByjoinDate(@Param("joinDate") String joinDate);

	@Query(value = CustomerQuery.getByName)
	List<CustomerDTO> getByName(@Param("name") String name);

	@Query(value = CustomerQuery.getByNameStart)
	List<CustomerDTO> getByNameStart(@Param("name") String name);

	@Query(value = CustomerQuery.getByNameEnd)
	List<CustomerDTO> getByNameEnd(@Param("name") String name);

	@Query(value = CustomerQuery.getByNameContains)
	List<CustomerDTO> getByNameContains(@Param("name") String name);

	@Query(value = CustomerQuery.checkPointBalance)
	double checkPointBalance(@Param("mobile") String mobile);

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	@Query(value = CustomerQuery.sortByJoinDate)
	List<CustomerDTO> sortByJoinDate();

	@Query(value = CustomerQuery.sortByArea)
	List<CustomerDTO> sortByArea();

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	@Transactional
	@Modifying
	@Query(value = CustomerQuery.updateName)
	int updateName(@Param("name") String name, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = CustomerQuery.updatePassword)
	int updatePassword(@Param("password") String password, @Param("newpwd") String newpwd,
			@Param("mobile") String mobile);


	@Transactional
	@Modifying
	@Query(value = CustomerQuery.updateArea)
	int updateArea(@Param("area") String area, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = CustomerQuery.updateStatus)
	int updateStatus(@Param("status") String status, @Param("mobile") String mobile);

	int countByMobile(@Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = CustomerQuery.updatePoint)
	int updatePointBalance(@Param("mobile") String mobile, @Param("point") double point);

}
