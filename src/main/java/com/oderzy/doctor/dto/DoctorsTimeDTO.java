package com.oderzy.doctor.dto;

import com.oderzy.doctor.model.DoctorsTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorsTimeDTO {
	
	protected String day;
	protected String date;
	protected String timee;
	
	
	
	public DoctorsTimeDTO(DoctorsTime d) {
		super();
		System.out.println("Object creating here  ");
		System.out.println(d.getMobile());
		this.day = d.getDay();
		this.timee = d.getTimee();
	}

	public DoctorsTimeDTO(DoctorsTimeDTO d) {
		super();
		this.day = d.getDay();
		this.timee = d.getTimee();
	}



	@Override
	public String toString() {
		return "DoctorsTimeDTO [day=" + day + ", date=" + date + ", timee=" + timee + "]";
	}



	public DoctorsTimeDTO(String day, String timee) {
		super();
		this.day = day;
		this.timee = timee;
	}



	
	
	
	
}
