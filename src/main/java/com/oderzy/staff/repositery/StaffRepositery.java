package com.oderzy.staff.repositery;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oderzy.staff.dto.StaffDTO;
import com.oderzy.staff.dto.StaffProfileDTO;
import com.oderzy.staff.model.Staff;
import com.oderzy.staff.model.query.StaffQuery;

public interface StaffRepositery extends JpaRepository<Staff, Integer> {

	@Query(value = StaffQuery.validate)
	String valid(@Param("mobile") String mobile, @Param("pwd") String pwd, 
			@Param("status") String status);

	@Query(value = StaffQuery.getByStaffId)
	StaffDTO getByStaffId(@Param("staffId") int staffId);

	@Query(value = StaffQuery.getByMobileComplete)
	StaffProfileDTO getByMobileComplete( @Param("mobile") String mobile);

	@Query(value = StaffQuery.getByMobile)
	StaffDTO getByMobile(@Param("mobile") String mobile);

	@Query(value = StaffQuery.getBySecondaryMobile)
	StaffDTO getBySecondaryMobile(@Param("mobile") String mobile);

	@Query(value = StaffQuery.getByName)
	List<StaffDTO> getByName(@Param("name") String name);

	@Query(value = StaffQuery.getByCity)
	List<StaffDTO> getByCity(@Param("city") String city);

	@Query(value = StaffQuery.getByJoinDate)
	List<StaffDTO> getByJoinDate(@Param("joinDate") Date joinDate);

	@Query(value = StaffQuery.sortByJoinDate)
	List<StaffDTO> sortByJoinDate();

	/*-----------------Updation Query-------------------*/
	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateMobile)
	int updateMobile(@Param("newmobile") String newmobile, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateEmail)
	int updateEmail(@Param("email") String email, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateSecondaryMobile)
	int updateSecondaryMobile(@Param("newmobile") String newmobile, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateName)
	int updateName(@Param("name") String name, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateDOB)
	int updateDOB(@Param("dob") Date dob, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updatePassword)
	int updatePassword(@Param("password") String password, @Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateIdentity)
	int updateIdentity(@Param("identityType") String identityType, @Param("identityProof") String identityProof,
			@Param("mobile") String mobile);

	@Transactional
	@Modifying
	@Query(value = StaffQuery.updateAddress)
	int updateAddress(@Param("line1") String line1, @Param("city") String city, @Param("pincode") int pincode,
			@Param("mobile") String mobile);


}
