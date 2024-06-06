package com.oderzy.pharma.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy.pharma.dto.MedicalStoreDTO;
import com.oderzy.pharma.dto.MedicalStoreInfoDTO;
import com.oderzy.pharma.model.MedicalStore;

public interface MedicalStoreRepositery extends JpaRepository<MedicalStore, String> {

	List<MedicalStoreDTO> findByAreacodeAndCategory(@Param("area") String area,@Param("category") String category);

	@Query("select new com.oderzy.pharma.dto.MedicalStoreInfoDTO(ms) from MedicalStore m  JOIN m.medicalStoreDetails ms where m.storeId = :storeId")
	MedicalStoreInfoDTO fetchMedicalStoreInfoById(@Param("storeId") String storeId);
	@Query("select new com.oderzy.pharma.dto.MedicalStoreInfoDTO(m) from MedicalStore m JOIN m.medicalStoreDetails ms where m.storeId = :storeId")
	MedicalStoreInfoDTO fetchMedicalStoreInfoById2(@Param("storeId") String storeId);


	MedicalStore findByStoreId(@Param("storeId") String storeId);
}
