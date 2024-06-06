package com.oderzy.helper;

import org.springframework.stereotype.Service;

@Service
public class CartCodeGenerator {

	private String todayCartCode = null;

	private static int cartNo;

	public void setCartNo(int number) {
		cartNo = number;
	}

	public int cartNo() {
		return cartNo;
	}

	public String getCartNo() {
		cartNo++;
		return this.todayCartCode + cartNo;
	}

	public void setCartCode(String todayCartCode) {
		this.todayCartCode = todayCartCode;
	}

	public int slNo() {
		cartNo++;
		return cartNo;
	}

}
