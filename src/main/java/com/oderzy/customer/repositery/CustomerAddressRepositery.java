package com.oderzy.customer.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.oderzy.customer.dto.CustomerAddressDTO;
import com.oderzy.customer.dto.CustomerDTO;
import com.oderzy.customer.dto.CustomerInfo;
import com.oderzy.customer.dto.CustomerProfileDTO;
import com.oderzy.customer.model.CustomerAddress;
import com.oderzy.customer.model.query.CustomerAddressQuery;

public interface CustomerAddressRepositery extends JpaRepository<CustomerAddress, String> {

	CustomerAddress findFirstByUser_Mobile(String mobile);

	@Query(value = CustomerAddressQuery.getCustomerAddressCountByMobile)
	int getAddressCount(@Param("mobile") String mobile);

/*	@Query(value = CustomerAddressQuery.getCoordinate)
	Coordinate getCoordinateByMobile(@Param("mobile") String mobile);
*/
	@Query(value = CustomerAddressQuery.getAreaByMobile)
	String getAreaByMobile(@Param("mobile") String mobile);
	
	@Query(value = CustomerAddressQuery.getCityByMobile)
	String getCityByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerAddressQuery.getAreaTypeByMobile)
	String getAreaTypeByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerAddressQuery.getCustomerInfoByMobile)
	CustomerInfo getCustomerInfoByMobile(@Param("mobile") String mobile);

	
	@Query(value = CustomerAddressQuery.getCustomerProfileByMobile)
	CustomerProfileDTO getCustomerProfileByMobile(@Param("mobile") String mobile);


	@Query(value = CustomerAddressQuery.getAddressesByMobile)
	CustomerAddressDTO getAddressesByMobile(@Param("mobile") String mobile);

	@Query(value = CustomerAddressQuery.getByRoad)
	List<CustomerDTO> getByRoad(@Param("road") String road);

	@Query(value = CustomerAddressQuery.getByLandmark)
	List<CustomerDTO> getByLandmark(@Param("landmark") String landmark);

	@Query(value = CustomerAddressQuery.getByCity)
	List<CustomerDTO> getByCity(@Param("city") String city);

	@Query(value = CustomerAddressQuery.getByPincode)
	List<CustomerDTO> getByPincode(@Param("pincode") int pincode);

	/* ,,,,,,,,,,,,,,,,,,,,,Sort Query,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,, */
	@Query(value = CustomerAddressQuery.sortByRoad)
	List<CustomerDTO> sortByRoad();

	@Query(value = CustomerAddressQuery.sortByCity)
	List<CustomerDTO> sortByCity();

	@Query(value = CustomerAddressQuery.sortByPincode)
	List<CustomerDTO> sortByPincode();

	/*
	 * ,,,,,,,,,,,,,,,,,,,,,Sort Query In Area,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,
	 */
	@Query(value = CustomerAddressQuery.sortByJoinDateInArea)
	List<CustomerDTO> sortByJoinDateInArea(@Param("area") String area);

	@Query(value = CustomerAddressQuery.sortByNameInArea)
	List<CustomerDTO> sortByNameInArea(@Param("area") String area);

	/* ,,,,,,,,,,,,,,,,,,,,Updation Query...,,,,,,,,, */

	@Transactional
	@Modifying
	@Query(value = CustomerAddressQuery.updatePlaceCode)
	int updatePlaceCode(@Param("placeCode") String placeCode, @Param("id") String id);

	@Transactional
	@Modifying
	@Query(value = CustomerAddressQuery.updateAddress)
	int updateAddress(@Param("phone") String phone, @Param("houseNo") String houseNo, @Param("road") String road,
			@Param("landmark") String landmark, @Param("id") String id);

	@Transactional
	@Modifying
	@Query(value = CustomerAddressQuery.updatePhone)
	int updatePhone(@Param("phone") String phone, @Param("id") String id);


	@Transactional
	@Modifying
	@Query(value = CustomerAddressQuery.updateCoordinates)
	int updateCoordinates(@Param("lat") double lat, @Param("lon") double lon, @Param("id") String id);

}
