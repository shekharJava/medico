package com.oderzy.doctor.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Pattern;

import com.oderzy.doctor.model.DoctorsAppointment;

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
public class DoctorsAppointmentDTO {

	protected String bookingId;
	protected String mobile;
	protected String category;
	protected String area;
	protected String address;
	protected String gps;
	private String time;
	private String fees;
	private boolean homeVisit;
	protected String name;
	protected String status;
	protected String patient;
	@Pattern(regexp = "^\\d{10}$", message = "Enter 10 digit valid mobile")
	protected String patientMobile;
	protected String info;
	protected LocalDateTime orderTime;

	public DoctorsAppointmentDTO(DoctorsAppointment d) {
		super();
		this.bookingId = d.getBookingId();
		this.mobile = d.getMobile();
		this.category = d.getCategory();
		this.area = d.getArea();
		this.address = d.getAddress();
		this.gps = d.getGps();
		this.time = d.getSlot();
		this.fees = d.getFees();
		this.homeVisit = d.isHomeVisit();
		this.name = d.getName();
		this.status = d.getStatus();
		this.patient = d.getPatient();
		this.patientMobile = d.getPatientMobile();
		this.info = d.getInfo();
		this.orderTime = d.getOrderTime();
	}

}
