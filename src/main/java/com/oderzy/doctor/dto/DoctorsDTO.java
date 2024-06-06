package com.oderzy.doctor.dto;

import com.oderzy.doctor.model.Doctors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DoctorsDTO{


	
	protected String id;

	protected String mobile;

	protected String address;

	protected String category;

	protected String gps;

	private String fees;

	private boolean homeVisit;

	private String visitFees;
	
	protected String name;

	protected String licence;

	private String qualification;

	private String experience;

	private String image;

	public DoctorsDTO(Doctors d) {
		super();
		this.id = d.getId();
		this.mobile = d.getMobile();
		this.address = d.getAddress();
		this.category = d.getCategory();
		this.gps = d.getGps();
		//this.timming = d.getTimming();
		this.fees = d.getFees();
		this.homeVisit = d.isHomeVisit();
		this.visitFees = d.getVisitFees();
		this.name = d.getName();
		this.qualification = d.getQualification();
		this.experience = d.getExperience();
		this.image = d.getImage();
		
	}


}
