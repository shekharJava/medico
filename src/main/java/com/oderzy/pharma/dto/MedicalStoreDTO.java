package com.oderzy.pharma.dto;

import com.oderzy.pharma.model.MedicalStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStoreDTO {


	protected String storeId;
	protected String name;
	protected String specaility;
	protected String timings;
	protected String locality;

	private String image;

	public MedicalStoreDTO(MedicalStore ms) {
		super();
		this.storeId = ms.getArea();
		this.name = ms.getName();
		this.specaility = ms.getSpecaility();
		this.timings = ms.getTimings();
		this.locality = ms.getLocality();
		this.image = ms.getImage();
	}
	
	
}
