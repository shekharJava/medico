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
public class Laboratory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	protected String storeId;
	protected String name;
	protected String specaility;
	protected String timings;
	//in which area of city
	protected String area;
	//to denote area code for internal use
	protected String areacode;
	//to denote area road where store is present for user refrence
	protected String locality;
	protected String offerCategory;
	protected String offerMsg;
	protected boolean status;
	private String image;

}
