package com.oderzy.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;
import com.oderzy.doctor.dto.DoctorsAppointmentDTO;
import com.oderzy.doctor.dto.DoctorsAppointmentVO;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.service.DoctorService;
import com.oderzy.wrapper.StringResponse;

@RestController
@RequestMapping($Navigation.Lab_controller)
@CrossOrigin
public class LabController {

	@Autowired
	private DoctorService service;

	/* ==================== Put Post mapping =========== */
	@GetMapping("/all/test/{area}")
	public List<DoctorsDTO> getAllTests(@PathVariable String area) {
		
		return null;
	}

	@GetMapping("/all/doctors/{category}/{area}")
	public List<DoctorsDTO> getAllDoctorsByCategory(@PathVariable String category, @PathVariable String area) {
		return service.getAllDoctorsByCategory(category, area);
	}

	@GetMapping("/available_slots/{mobile}/{days}")
	public List<DoctorsTimeDTO> getAllSlotsAvailableForBooking(@PathVariable String mobile, @PathVariable int days) {
		return service.getAvailableSlots(mobile, 3);
	}

	@GetMapping("/all/booking/doctors/{id}")
	public List<DoctorsAppointmentDTO> getAllBookingsByDr(@PathVariable String id) {
		return service.getAllBookingByDr(id);
	}

	@GetMapping("/all/booking/patient/{mobile}")
	public List<DoctorsAppointmentDTO> getAllBookingByPatient(@PathVariable String mobile) {
		return service.getAllBookingByUser(mobile);
	}

	@GetMapping("/all/booking/status/{status}")
	public List<DoctorsAppointmentDTO> getAllBookingByStatus(@PathVariable String status) {
		return service.getAllBookingByStatus(status);
	}

	@PostMapping("/book/request")
	public StringResponse bookAppointment(@RequestBody DoctorsAppointmentVO vo) {
		return new StringResponse(service.newBooking(vo));
	}

	@PutMapping("/confirm/appointment")
	public void confirmAppointment(@PathVariable String id, @PathVariable String token, @RequestParam String info) {
		service.confirmBooking(id, token, info);
	}

	@PutMapping("/failed/appointment")
	public void failedAppointment(@PathVariable String id, @PathVariable String token, @RequestParam String info) {
		service.FailedBooking(id, token, info);
	}

}
