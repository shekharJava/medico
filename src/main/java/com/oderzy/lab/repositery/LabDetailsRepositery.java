package com.oderzy.lab.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.lab.model.LabDetails;

public interface LabDetailsRepositery extends JpaRepository<LabDetails, String> {

	}
