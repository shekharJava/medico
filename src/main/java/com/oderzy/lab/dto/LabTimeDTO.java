package com.oderzy.lab.dto;

import com.oderzy.doctor.model.DoctorsTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTimeDTO {
	
	protected String day;
	protected String date;
	protected String timee;
	
	
	
	public LabTimeDTO(DoctorsTime d) {
		super();
		System.out.println("Object creating here  ");
		System.out.println(d.getMobile());
		this.day = d.getDay();
		this.timee = d.getTimee();
	}

	public LabTimeDTO(LabTimeDTO d) {
		super();
		this.day = d.getDay();
		this.timee = d.getTimee();
	}



	@Override
	public String toString() {
		return "DoctorsTimeDTO [day=" + day + ", date=" + date + ", timee=" + timee + "]";
	}



	public LabTimeDTO(String day, String timee) {
		super();
		this.day = day;
		this.timee = timee;
	}



	
	
	
	
}
