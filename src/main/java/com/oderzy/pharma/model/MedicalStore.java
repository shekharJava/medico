package com.oderzy.pharma.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
public class MedicalStore implements Serializable {



	private static final long serialVersionUID = -1L;

	@Id
	private String storeId;
	private String name;
	//category of the store like drug store, homeopathy lab 
	private String category;
	//what are the thing available here
	
	private String specaility;
	//8AM -9PM
	private String timings;
	//in which area of city
	private String area;
	//to denote area code for internal use
	private String areacode;
	//to denote area road where store is present for user refrence
	private String locality;
	private String offerCategory;
	private String offerMsg;
	private boolean status;
	private String image;
	
	@OneToOne(mappedBy = "store", fetch = FetchType.LAZY)
	private MedicalStoreDetails medicalStoreDetails;



}
