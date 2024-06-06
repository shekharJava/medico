package com.oderzy._exception_.oderzy;

public class CustomerProfileExistsException extends PharmaBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 756493237715401246L;

	

	public CustomerProfileExistsException() {
		super("Customer Profile Already exists please login");
		// TODO Auto-generated constructor stub
	}

	public CustomerProfileExistsException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
