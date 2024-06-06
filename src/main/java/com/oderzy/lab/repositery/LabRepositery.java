package com.oderzy.lab.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.lab.model.Laboratory;

public interface LabRepositery extends JpaRepository<Laboratory, String> {

	}
