package com.oderzy.pharma.service;

import java.util.List;

import com.oderzy.pharma.dto.MedicalBookingDTO;
import com.oderzy.pharma.dto.MedicalBookingVO;
import com.oderzy.pharma.dto.MedicalStoreDTO;
import com.oderzy.wrapper.StringResponse;

public interface MedicalStoreService {

	public List<MedicalStoreDTO> getDrugStore(String area) ;

	public List<MedicalStoreDTO> getHomeoAndAyurvedaStore(String area) ;

	public List<MedicalBookingDTO> getBookingByStatus(String status);

	public List<MedicalBookingDTO> getBookingByUser(String mobile);

	public List<MedicalBookingDTO> getBookingByStore(String storeId) ;

	public StringResponse bookMedicineRequest(MedicalBookingVO vo);
}
