package com.oderzy.doctor.model;

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
public class Doctors implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	protected String id;
	protected String mobile;
	protected String category;
	protected String area;
	protected String address;
	protected String gps;
	private String fees;
	private boolean homeVisit;
	private String visitFees;
	protected String name;
	protected String licence;
	private String qualification;
	private String experience;
	private String image;
	

	
	
}
