package com.oderzy.helper;

import org.springframework.stereotype.Service;

@Service
public class CallCodeGenerator {

	private String todayCALLCode = null;

	private static int callerNo;

	public void setCallerNo(int number) {
		callerNo = number;
	}

	public int callerNo() {
		return callerNo;
	}

	public String getCallerCode() {
		callerNo++;
		return this.todayCALLCode + callerNo;
	}

	public String getTodayCallerCode() {
		return this.todayCALLCode;
	}

	public void setTodayCallerCode(String todayCALLCode) {
		this.todayCALLCode = todayCALLCode;
	}

}
