package com.oderzy.pharma.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oderzy.helper.OrderCodeGenerator;
import com.oderzy.pharma.dto.MedicalBookingDTO;
import com.oderzy.pharma.dto.MedicalBookingVO;
import com.oderzy.pharma.dto.MedicalStoreDTO;
import com.oderzy.pharma.dto.MedicalStoreInfoDTO;
import com.oderzy.pharma.model.MedicalBooking;
import com.oderzy.pharma.repositery.MedicalBookingRepositery;
import com.oderzy.pharma.repositery.MedicalStoreRepositery;
import com.oderzy.wrapper.StringResponse;

@Service
public class MedicalStoreServiceImpl implements MedicalStoreService {

	private MedicalBookingRepositery bRepo;

	private MedicalStoreServiceImpl(MedicalBookingRepositery bRepo) {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private MedicalStoreRepositery repo;

	@Autowired
	private OrderCodeGenerator codeGenerator;

	public List<MedicalStoreDTO> getDrugStore(String area) {

		return repo.findByAreacodeAndCategory(area, "DRUG");
	}

	public List<MedicalStoreDTO> getHomeoAndAyurvedaStore(String area) {

		return repo.findByAreacodeAndCategory(area, "Ayurveda");
	}

	public List<MedicalStoreDTO> getLab(String area) {

		return repo.findByAreacodeAndCategory(area, "Lab");
	}

	public List<MedicalBookingDTO> getBookingByStatus(String status) {

		return bRepo.findByStatus(status);
	}

	public List<MedicalBookingDTO> getBookingByUser(String mobile) {

		return bRepo.findByUserMobile(mobile);
	}

	public List<MedicalBookingDTO> getBookingByStore(String storeId) {

		return bRepo.findByStoreId(storeId);
	}

	public MedicalStoreInfoDTO getMedicalStoreInfo(String storeId) {
		System.out.println(repo.findByStoreId(storeId));
		System.out.println(repo.fetchMedicalStoreInfoById(storeId));
		System.out.println(repo.fetchMedicalStoreInfoById2(storeId));

		return repo.fetchMedicalStoreInfoById(storeId);
	}

	@Override
	public StringResponse bookMedicineRequest(MedicalBookingVO vo) {
		System.out.println(vo.getStoreId());
		MedicalStoreInfoDTO store = this.getMedicalStoreInfo(vo.getStoreId());
		System.out.println(store);
		String orderId = codeGenerator.getOrderCode().toString();
		new MedicalBooking(orderId, store.getMobile(), vo.getStoreId(), store.getArea(), store.getAddress(),
				store.getGps(), 0.0, 25.0, store.getName(), "Pending", vo.getUser(), vo.getUserMobile(),
				vo.getUserAddress(), vo.getUsergps(), LocalDateTime.now(), LocalDateTime.now().plusHours(1));
		return new StringResponse(orderId);
	}
}
