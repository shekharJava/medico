package com.oderzy.lab.dto;

import com.oderzy.lab.model.Laboratory;

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
public class LabDTO{


	protected String storeId;
	protected String name;
	protected String specaility;
	protected String timings;
	protected String locality;

	private String image;

	public LabDTO(Laboratory l) {
		super();
		this.storeId = l.getArea();
		this.name = l.getName();
		this.specaility = l.getSpecaility();
		this.timings = l.getTimings();
		this.locality = l.getLocality();
		this.image = l.getImage();
	}
	
	

}
