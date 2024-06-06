package com.oderzy.pharma.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class MedicalStoreDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1029375876253144963L;

	@Id
	private String id;
	private String mobile;
	private String mobile2;
	private String address;
	private String gps;
	private String licence;
	private String contactPerson;
	private String gst;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	private MedicalStore store;
}
