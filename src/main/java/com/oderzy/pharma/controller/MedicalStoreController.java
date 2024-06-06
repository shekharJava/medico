package com.oderzy.pharma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;
import com.oderzy.pharma.dto.MedicalBookingDTO;
import com.oderzy.pharma.dto.MedicalBookingVO;
import com.oderzy.pharma.dto.MedicalStoreDTO;
import com.oderzy.pharma.service.MedicalStoreService;
import com.oderzy.wrapper.StringResponse;

@RestController
@RequestMapping($Navigation.Med_controller)
@CrossOrigin
public class MedicalStoreController {

	@Autowired
	private MedicalStoreService service;

	/* ==================== Put Post mapping =========== */
	@GetMapping("/medical/stores/{area}")
	public List<MedicalStoreDTO> getAllMedicalStores(@PathVariable String area) {
	
		return service.getDrugStore(area);
	}

	@GetMapping("/homeo/stores/{area}")
	public List<MedicalStoreDTO> getAllHomeoStores(@PathVariable String area) {
		return service.getHomeoAndAyurvedaStore(area);
	}

	@GetMapping("/ayurveda/stores/{area}")
	public List<MedicalStoreDTO> getAllAyurvedaStores(@PathVariable String area) {
		return service.getHomeoAndAyurvedaStore(area);
	}


	@GetMapping("/booking/status/{status}")
	public List<MedicalBookingDTO> getAllBookingByStatus(@PathVariable String status) {
		return service.getBookingByStatus(status);
	}

	@GetMapping("/booking/user/{mobile}")
	public List<MedicalBookingDTO> getAllBookingByUser(@PathVariable String mobile) {
		return service.getBookingByUser(mobile);
	}

	@GetMapping("/booking/stores/{id}")
	public List<MedicalBookingDTO> getAllBookingByStore(@PathVariable String id) {
		return service.getBookingByStore(id);
	}
	@PostMapping("/booking/request")
	public StringResponse booKMedicine(@RequestBody MedicalBookingVO vo) {
		return service.bookMedicineRequest(vo);
	}
}
