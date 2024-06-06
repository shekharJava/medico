package com.oderzy._exception_.oderzy;

public class NoRecordFound extends PharmaBaseException {

	
	private static final long serialVersionUID = 1L;



	public NoRecordFound() {
		super("No record found matching requested resource");
		// TODO Auto-generated constructor stub
	}

	public NoRecordFound(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
