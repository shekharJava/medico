package com.oderzy._exception_.oderzy;

public class LoginExpiredException extends PharmaBaseException {

	
	
	private static final long serialVersionUID = 1L;

	public LoginExpiredException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public LoginExpiredException() {
		super("You must relogin to continue");
		// TODO Auto-generated constructor stub
	}


	
}
