package com.oderzy.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class OrderCodeGenerator {

	private String todayOrderCode = null;
	private String todayInvoiceCode = null;
	private List<Integer> todayOrderCodeList = null;
	private List<Integer> todayInvoiceCodeList = null;



	public String gettodayOrderCode() {
		return this.todayOrderCode;
	}

	public StringBuffer getOrderCode() {
		return new StringBuffer(todayOrderCode).append(todayOrderCodeList.remove(0));
	}

	public StringBuffer getInvoiceCode() {
		return new StringBuffer(todayInvoiceCode).append(todayInvoiceCodeList.remove(0));
	}

	public void setTodayOrderCode(String todayOrderCode) {
		this.todayOrderCode = todayOrderCode;
	}

	public void setTodayInvoiceCode(String todayInvoiceCode) {
		this.todayInvoiceCode = todayInvoiceCode;
	}

	public void setTodayOrderCodeList(Set<Integer> c) {
		this.todayOrderCodeList = new ArrayList<Integer>();
		this.todayOrderCodeList.addAll(c);
		Collections.shuffle(todayOrderCodeList);
	}

	public void setTodayInvoiceCodeList(Set<Integer> c) {
		this.todayInvoiceCodeList = new ArrayList<Integer>();
		todayInvoiceCodeList.addAll(c);
	}

}
