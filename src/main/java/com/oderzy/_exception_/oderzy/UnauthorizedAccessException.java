package com.oderzy._exception_.oderzy;

import org.springframework.stereotype.Component;

@Component
public class UnauthorizedAccessException extends PharmaBaseException {

	private static final long serialVersionUID = 1L;



	public UnauthorizedAccessException() {
		super("You dont have permission");
		// TODO Auto-generated constructor stub
	}

	
}
