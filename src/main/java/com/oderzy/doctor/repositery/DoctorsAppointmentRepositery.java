package com.oderzy.doctor.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.oderzy.doctor.dto.DoctorsAppointmentDTO;
import com.oderzy.doctor.model.DoctorsAppointment;

public interface DoctorsAppointmentRepositery extends JpaRepository<DoctorsAppointment, String> {

	// by Dr Mobile
	List<DoctorsAppointmentDTO> findByMobile(@Param("mobile") String mobile);

	List<DoctorsAppointmentDTO> findByPatientMobile(@Param("patientMobile") String patientMobile);

	List<DoctorsAppointmentDTO> findByStatus(@Param("status") String status);

	DoctorsAppointment findByBookingId(@Param("bookingId") String bookingId);

}
