package com.oderzy.doctor.controller;

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
import com.oderzy.doctor.service.DoctorService;
import com.oderzy.wrapper.StringResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping($Navigation.Doc_controller)
@CrossOrigin
@Tag(name = "Appointment Endpoint")
public class DoctorAppointmentController {

	private DoctorAppointmentController(DoctorService service) {

	}

	@Autowired
	private DoctorService service;

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

	@Operation(summary = "Perform appointment booking of a doctor by user app")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A Confirm Booking Will provide a valid appointment Id"),
			@ApiResponse(responseCode = "500", description = "Failed to Book an error message thrown no appointment id will be generated") })
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
