package com.oderzy.doctor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.repositery.DoctorsRepositery;
import com.oderzy.doctor.repositery.DoctorsTimeRepositery;
import com.oderzy.doctor.service.DoctorsServiceImpl;

//@SpringBootTest(classes = { TestDoctorService.class })
//@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class TestDoctorService {

	@Mock
	DoctorsRepositery doctorsRepositery;
	@Mock
	DoctorsTimeRepositery doctorsTimeRepositery;

	@InjectMocks
	DoctorsServiceImpl doctorService;

	static List<DoctorsDTO> doctorsDTOs;
	static List<DoctorsDTO> doctorsDTOsHeart;
	static List<DoctorsTimeDTO> doctorsTimeDTOs;
	static String area;
	static String category;
	static String mobile;
	static String idString;

	@BeforeAll
	public static void valueInitalize() {
		area = "MZP001";
		doctorsDTOs = new ArrayList<DoctorsDTO>();
		doctorsDTOsHeart = new ArrayList<DoctorsDTO>();
		category = "Heart";
		mobile = "9900867495";
		idString = "AXX550";

		doctorsTimeDTOs = new ArrayList<DoctorsTimeDTO>();

		doctorsDTOs.add(new DoctorsDTO("AXX550", "8674998145", "kachari road", "Eye", "", "500", false, "500",
				"Dr Rakesh Sinha", "55656898489", "MD Eye", "16 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX551", "8674440532", "vip road", "Ortho", "", "500", false, "500",
				"Dr Meera Bhagat", "55656898489", "Mbbs", "8 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX552", "9900867495", "lal bag", "Heart", "", "900", false, "500",
				"Dr Lal Chadda", "55656898489", "MD MS Heart", "12 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX553", "8887464587", "kachari road", "Nuero", "", "800", false, "500",
				"Dr Harjit Patel", "55656898489", "MBBS", "10 years", ""));
		doctorsDTOs.add(new DoctorsDTO("AXX556", "7495715565", "shyampur", "General", "", "300", false, "500",
				"Dr Mena sai", "55656898489", "MBBS MS", "6 years", ""));

		doctorsDTOsHeart.add(new DoctorsDTO("AXX552", "9900867495", "lal bag", "Heart", "", "900", false, "500",
				"Dr Lal Chadda", "55656898489", "MD MS Heart", "12 years", ""));
		doctorsDTOsHeart.add(new DoctorsDTO("AXX552", "9900553674", "lal bag", "Heart", "", "300", false, "500",
				"Dr Geeta Chandra", "55656898489", "MD MS Heart", "8 years", ""));

		doctorsTimeDTOs.add(new DoctorsTimeDTO("Sunday", "11-11-2023", "9-11AM"));
		doctorsTimeDTOs.add(new DoctorsTimeDTO("Sunday", "11-11-2023", "7-9PM"));
		doctorsTimeDTOs.add(new DoctorsTimeDTO("Monday", "12-11-2023", "5-8PM"));
		doctorsTimeDTOs.add(new DoctorsTimeDTO("Wednesday", "14-11-2023", "6-9PM"));
	}

	@Test
	public void getAllDoctorsTest() {
	  when(doctorsRepositery.findByArea(area)).thenReturn(doctorsDTOs);
	 assertEquals("8674998145", doctorService.getAllDoctors(area).get(0).getMobile()); 
	 
	 }

	

	@Test
	public void sumTest() {
		assertEquals(13, DoctorsServiceImpl.sumMe(8, 5));
	}

	@Test
	public void getAllDoctorsByCategory() {
		when(doctorsRepositery.findByAreaAndCategory(area, category)).thenReturn(doctorsDTOsHeart);
	
	assertEquals(category, doctorService.getAllDoctorsByCategory(category, area).get(0).getCategory());
}

	@Test
	public void getAvailableSlots() {
		when(doctorsTimeRepositery.findAllByMobile(mobile,"Active")).thenReturn(doctorsTimeDTOs);
		assertEquals(4, doctorService.getAvailableSlots(mobile, 4).size());
	}

}
