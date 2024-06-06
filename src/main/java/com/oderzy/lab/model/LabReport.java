package com.oderzy.lab.model;

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
public class LabReport {
	
	@Id
	private String id;
	private String invoiceId;
	private String labId;
	private String testId;
	private String testName;
	private String testResult;
	private String testDetails;


}
