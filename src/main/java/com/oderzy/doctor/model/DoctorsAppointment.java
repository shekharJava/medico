package com.oderzy.doctor.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DoctorsAppointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	protected String bookingId;

	//Dr mobile
	protected String mobile;

	protected String category;

	protected String area;

	protected String address;

	protected String gps;

	private String slot;

	protected String token;

	private String fees;

	private boolean homeVisit;
	
	protected String name;
	
	protected String status;
	
	protected String patient;
	
	protected String patientMobile;
	
	protected String info;
	protected LocalDateTime orderTime;

	
}
