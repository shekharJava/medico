package com.oderzy.helper;

import org.springframework.stereotype.Service;

@Service
public class CustomerCodeGenerator {

	private String todayCustomerCode = null;

	private static int customerNo;
	private static int customerAddressNo;

	public void setCustomerNo(int number) {
		customerNo = number;
	}
	public void setCustomerAddressNo(int number) {
		customerAddressNo=number;
	}
	public int customerNo() {
		return customerNo;
	}
	public int customerAddressNo() {
		return customerAddressNo;
	}

	public String getCustomerCode() {
		customerNo++;
		return this.todayCustomerCode + customerNo;
	}
	public String getCustomerAddressCode() {
		customerAddressNo++;
		return this.todayCustomerCode + customerAddressNo;
	}
	public void setTodayCustomerCode(String todayCustomerCode) {
		this.todayCustomerCode = todayCustomerCode;
	}

}
