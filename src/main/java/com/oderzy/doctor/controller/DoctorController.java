package com.oderzy.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.oderzy.$config.constants.$Navigation;
import com.oderzy.customer.model.Customer;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.service.DoctorService;
import com.oderzy.sms.api.SmsFeignClient;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping($Navigation.Doc_controller)
@CrossOrigin
@Tag(name = "Docotor Endpoint")
public class DoctorController {

	private DoctorController(DoctorService service) {

	}

	@Autowired
	private DoctorService service;
	@Autowired
	private SmsFeignClient smsFeignClient;
	public String msgString = "Radhe Radhe";

	@GetMapping("/test")
	public List<DoctorsDTO> getAllDocs() {
		return smsFeignClient.getAllDoctors(new Customer(), "MZP001");
	}

	/*
	 * @Operation(summary = "Provide List of Doctors based on the areacode provide")
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(responseCode = "200", description =
	 * "A valid response with List of Doctors data"),
	 * 
	 * @ApiResponse(responseCode = "400", description =
	 * "Inavlid Request Please verify Requeest uri and path value") })
	 */
	@GetMapping("/all/doctors/{area}")
	public List<DoctorsDTO> getAllDoctors(@PathVariable String area) {
		System.out.println("---------" + area);
		return service.getAllDoctors(area);
	}

	@GetMapping("/all/doctors/{category}/{area}")
	public List<DoctorsDTO> getAllDoctorsByCategory(@PathVariable String category, @PathVariable String area) {
		return service.getAllDoctorsByCategory(category, area);
	}

	@GetMapping("/available_slots/{mobile}/{days}")
	public List<DoctorsTimeDTO> getAllSlotsAvailableForBooking(@PathVariable String mobile, @PathVariable int days) {
		return service.getAvailableSlots(mobile, 3);
	}

}
