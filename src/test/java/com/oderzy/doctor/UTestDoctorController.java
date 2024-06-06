package com.oderzy.doctor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.oderzy.doctor.controller.DoctorController;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.service.DoctorsServiceImpl;

@SpringBootTest(classes = { UTestDoctorController.class })
@TestInstance(Lifecycle.PER_CLASS)
public class UTestDoctorController {

	@Mock
	DoctorsServiceImpl doctorService;

	@InjectMocks
	DoctorController doctorController;

	List<DoctorsDTO> doctorsDTOs;
	List<DoctorsTimeDTO> doctorsTimeDTOs;
	String area;
	String category;
	String mobile;

	@BeforeAll
	public void valueInitalize() {
		area = "MZP001";
		doctorsDTOs = new ArrayList<DoctorsDTO>();
		category = "Heart";
		mobile = "9900867495";

		doctorsTimeDTOs = new ArrayList<DoctorsTimeDTO>();

		doctorsDTOs.add(new DoctorsDTO("AXX550", "8674998145", "kachari road", "Eye", "", "500", false, "500",
				"Dr Rakesh Sinha", "55656898489", "MD Eye", "16 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX551", "8674440532", "vip road", "Ortho", "", "500", false, "500",
				"Dr Meera Bhagat", "55656898489", "Mbbs", "8 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX552", "9900867495", "lal bag", "Heart", "", "300", false, "500",
				"Dr Lal Chadda", "55656898489", "MD MS Heasrt", "12 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX553", "8887464587", "kachari road", "Nuero", "", "800", false, "500",
				"Dr Harjit Patel", "55656898489", "MBBS", "10 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX556", "7495715565", "shyampur", "General", "", "300", false, "500",
				"Dr Mena sai", "55656898489", "MBBS MS", "6 years", ""));

		doctorsTimeDTOs.add(new DoctorsTimeDTO("SUNDAY", "11-11-2023", "9-11AM"));
		doctorsTimeDTOs.add(new DoctorsTimeDTO("MONDAY", "12-11-2023", "5-8PM"));
		doctorsTimeDTOs.add(new DoctorsTimeDTO("WEDNESDAY", "14-11-2023", "6-9PM"));
	}

	@Test
	@Order(1)
	public void getAllSlotsAvailableForBooking() {
		when(doctorService.getAvailableSlots(mobile, 3)).thenReturn(doctorsTimeDTOs);
		System.out.println(doctorController.getAllSlotsAvailableForBooking(mobile, 3));
		assertEquals(3, doctorController.getAllSlotsAvailableForBooking(mobile, 3).size());

	}

	//
	@Test
	@Order(2)
	public void getAllDoctorsByCategory() {
		when(doctorService.getAllDoctorsByCategory(category, area)).thenReturn(doctorsDTOs);
		// assertEquals("12 years", doctorController.getAllDoctorsByCategory(category,
		// area).get(0).getExperience());
		assertSame(doctorsDTOs.get(0), doctorController.getAllDoctorsByCategory(category, area).get(0));
		assertNull(doctorController.getAllDoctorsByCategory(category, "MZP002").get(0));
	}

	@Test
	@Order(4)
	public void getAllSlotsAvailableForBooking2() {
		when(doctorService.getAvailableSlots(mobile, 3)).thenReturn(doctorsTimeDTOs);
		System.out.println(doctorController.getAllSlotsAvailableForBooking(mobile, 3));
		assertEquals(3, doctorController.getAllSlotsAvailableForBooking(mobile, 3).size());

	}

	@Test
	@Order(3)
	public void getAllDoctors() {
		when(doctorService.getAllDoctors(area)).thenReturn(doctorsDTOs);

		assertAll(() -> assertEquals(5, doctorController.getAllDoctors(area).size()),
				() -> assertEquals("500", doctorController.getAllDoctors(area).get(0).getFees()));
		assertEquals(5, doctorController.getAllDoctors(area).size());
	}

	public void getAllBookingByPatient() {
	}

	public void getAllBookingsByDr() {
	}

	public void getAllBookingByStatus() {
	}

	public void bookAppointment() {
	}

	public void confirmAppointment() {
	}

	public void failedAppointment() {
	}

	public void FailedBooking() {
	}
}
