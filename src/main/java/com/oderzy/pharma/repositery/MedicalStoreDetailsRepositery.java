package com.oderzy.pharma.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.pharma.model.MedicalStoreDetails;

public interface MedicalStoreDetailsRepositery extends JpaRepository<MedicalStoreDetails, String> {

	
}
