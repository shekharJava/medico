package com.oderzy.lab.model;

import java.io.Serializable;

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
public class LabTest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	protected String testId;
	protected String labIdString;
	protected String name;
	protected String category;
	protected String description;
	protected String guidlines;

	//Will be in hr like 6-9  or 8-20
	protected String testTime;
	//will be in duration by hr like 2hr   36hr 
	protected String resultTime;

	protected String homeVisitString;
	protected double fees;
	protected double homeVisitCharge;
	
	protected boolean status;

}
