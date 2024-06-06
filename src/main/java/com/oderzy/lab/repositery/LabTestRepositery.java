package com.oderzy.lab.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.lab.model.LabTest;

public interface LabTestRepositery extends JpaRepository<LabTest, String> {

	
	
}
