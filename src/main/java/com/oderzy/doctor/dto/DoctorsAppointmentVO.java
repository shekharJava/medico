package com.oderzy.doctor.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorsAppointmentVO {

	// Dr mobile
	protected String mobile;

	private String bookingSlot;

	private String fees;

	private boolean homeVisit;

	protected String patient;

	protected String patientMobile;

	protected String patientAddress;

}
