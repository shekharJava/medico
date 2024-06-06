package com.oderzy._exception_.oderzy;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oderzy._exception_.oderzy.doctor.NoDoctorFoundException;
import com.oderzy._exception_.oderzy.pharma.NoMedicalRecordFoundException;
import com.oderzy.wrapper.StringResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class PharmaExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoDoctorFoundException.class)
	protected StringResponse handle(NoDoctorFoundException ex) {
		return new StringResponse(ex.getMessage());

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoMedicalRecordFoundException.class)
	protected StringResponse handle(NoMedicalRecordFoundException ex) {
		return new StringResponse(ex.getMessage());
	}

	@ExceptionHandler(CustomerProfileExistsException.class)
	protected ResponseEntity<Object> handle(CustomerProfileExistsException ex) {

		return new ResponseEntity<>(new StringResponse(ex.getMessage()), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UnauthorizedAccessException.class)
	protected ResponseEntity<Object> handle(UnauthorizedAccessException ex) {
	
		return new ResponseEntity<>(new StringResponse(ex.getMessage()), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(LoginExpiredException.class)
	protected ResponseEntity<Object> handle(LoginExpiredException ex) {
		StringResponse error = new StringResponse(ex.getMessage());
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(NoRecordFound.class)
	protected ResponseEntity<Object> handle(NoRecordFound ex) {
		StringResponse error = new StringResponse(ex.getMessage());
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(InvalidLoginCredential.class)
	protected ResponseEntity<Object> handle(InvalidLoginCredential ex) {
		StringResponse error = new StringResponse(ex.getMessage());
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<>(error, status);
	}

	@ExceptionHandler(InvalidOTP.class)
	protected ResponseEntity<Object> handle(InvalidOTP ex) {
		StringResponse error = new StringResponse(ex.getMessage());
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<>(error, status);
	}
}
