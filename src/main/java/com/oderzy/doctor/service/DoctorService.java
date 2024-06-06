package com.oderzy.doctor.service;

import java.util.List;

import com.oderzy._exception_.oderzy.doctor.NoDoctorFoundException;
import com.oderzy.doctor.dto.DoctorsAppointmentDTO;
import com.oderzy.doctor.dto.DoctorsAppointmentVO;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;

public interface DoctorService {

	public List<DoctorsDTO> getAllDoctors(String area)throws NoDoctorFoundException;

	public List<DoctorsDTO> getAllDoctorsByCategory(String category, String area);

	public List<DoctorsTimeDTO> getAvailableSlots(String mobile, int days);

	public List<DoctorsTimeDTO> getDayStringNew(List<DoctorsTimeDTO> list, int dayCount);

	public List<DoctorsAppointmentDTO> getAllBookingByUser(String mobile);

	public List<DoctorsAppointmentDTO> getAllBookingByStatus(String status);

	public List<DoctorsAppointmentDTO> getAllBookingByDr(String mobile);

	public String newBooking(DoctorsAppointmentVO vo);

	public void confirmBooking(String bookingId, String token, String info);

	public void FailedBooking(String bookingId, String token, String info);

	
	


}
