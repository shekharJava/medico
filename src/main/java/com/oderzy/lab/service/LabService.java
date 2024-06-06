package com.oderzy.lab.service;

import java.util.List;

import com.oderzy.doctor.dto.DoctorsDTO;

public interface LabService {

	public List<DoctorsDTO> getAllLabs(String area);

	public List<DoctorsDTO> getAllLabsByCategory(String category, String area);


	}
