package com.oderzy._exception_.oderzy;

public class AddressRequiredException extends PharmaBaseException {

	
	private static final long serialVersionUID = 1L;

	

	public AddressRequiredException() {
		super("User Must have at least one address");
		// TODO Auto-generated constructor stub
	}

	public AddressRequiredException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
