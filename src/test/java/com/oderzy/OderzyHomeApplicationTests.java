package com.oderzy;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.oderzy.doctor.controller.DoctorController;
import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.service.DoctorService;

@SpringBootTest(classes = {OderzyHomeApplicationTests.class})
class OderzyHomeApplicationTests {


	@Mock
	DoctorService doctorService;
	@InjectMocks
	DoctorController doctorController;
	List<DoctorsDTO> doctorsDTOs;
	String area;
	
	/*   oo
	 * @Test public void getAllDoctors() throws Exception { doctorsDTOs = new
	 * ArrayList<>(); doctorsDTOs.add(new DoctorsDTO("AXX556", "8674957155",
	 * "kachari road", "Eye", "", "500", false, "500", "Dr Rakesh Sinha",
	 * "55656898489", "MD Eye", "6 years", "")); area = "MZP001";
	 * when(doctorService.getAllDoctors(area)).thenReturn(doctorsDTOs);
	 * 
	 * //List<DoctorsDTO> res = doctorController.getAllDoctors(area);
	 * System.out.println(res); System.out.println(res.size());
	 * 
	 * assertEquals(1, res.size()); }
	 */


}
