package com.oderzy.pharma.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.oderzy.pharma.dto.MedicalBookingDTO;
import com.oderzy.pharma.model.MedicalBooking;

public interface MedicalBookingRepositery extends JpaRepository<MedicalBooking, String> {

	List<MedicalBookingDTO> findByUserMobile(@Param("userMobile") String mobile);

	List<MedicalBookingDTO> findByStoreId(@Param("storeId") String storeId);

	List<MedicalBookingDTO> findByStatus(@Param("status") String status);

}
