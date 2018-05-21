package com.curveDental.exception;
public class ValidationException extends ApplicationException {
	public ValidationException(String message, String errorCode) {
		super(message, errorCode);
	}
}