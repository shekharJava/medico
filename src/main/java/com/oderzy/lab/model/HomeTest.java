package com.oderzy.lab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
public class HomeTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1029375876253144963L;

	@Id
	protected String id;
	@OneToOne
	@JoinColumn(name = "appointment")
	protected LabAppointment appointment;
	private double homeFees;
	//mobile of the home visiting lab boy
	protected String mobile;
	private String  slot;
	

	

}
