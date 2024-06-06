package com.oderzy.lab.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class LabAppointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	protected String bookingId;
	// Lab mobile
	protected String mobile;
	// Lab Category
	protected String category;
	// Lab Name
	protected String name;
	protected String area;
	protected String address;
	protected String gps;
	private String slot;
	protected String token;
	private double fees;
	private boolean homeVisit;
	// Status of booking
	protected String status;

	protected String patient;
	protected String patientMobile;
	protected int age;
	protected String gender;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn
	private List<LabReport> reports;
	protected String info;
	protected LocalDateTime orderTime;

}
