package com.oderzy.doctor.service;

import java.util.ArrayList;
import java.util.List;

import com.oderzy.doctor.dto.DoctorsDTO;

public enum DoctorsData {
	INSTANCE;
	private static ArrayList<DoctorsDTO> docs = new ArrayList<>();
	
	public List<DoctorsDTO> get(){
		return docs;
	}
	
	


}
