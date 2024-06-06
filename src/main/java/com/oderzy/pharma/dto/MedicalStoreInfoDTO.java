package com.oderzy.pharma.dto;

import com.oderzy.pharma.model.MedicalStore;
import com.oderzy.pharma.model.MedicalStoreDetails;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MedicalStoreInfoDTO {

	private String name;
	private String mobile;
	private String gps;

	private String area;

	private String address;

	public MedicalStoreInfoDTO(String name, String mobile, String area, String gps, String address) {
		System.out.println("----------1---------------");
		System.out.println(name + " " + address);
		this.name = name;
		this.mobile = mobile;
		this.gps = gps;
		this.area = area;
		this.address = address;
	}

	public MedicalStoreInfoDTO(MedicalStoreDetails msd) {

		System.out.println("--------2-----------------");
		System.out.println(msd);
	}
	public MedicalStoreInfoDTO(MedicalStore m) {

		System.out.println("---------------4----------");
		System.out.println(m);
	}

}
