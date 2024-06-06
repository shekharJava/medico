package com.oderzy._exception_.oderzy;

import org.springframework.stereotype.Component;

@Component
public abstract class PharmaBaseException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;


	public PharmaBaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PharmaBaseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public PharmaBaseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PharmaBaseException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PharmaBaseException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
