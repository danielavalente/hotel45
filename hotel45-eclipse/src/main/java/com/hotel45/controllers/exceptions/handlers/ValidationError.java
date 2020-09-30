package com.hotel45.controllers.exceptions.handlers;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	//Create a list of errors
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(int status, String message, Long timeStamp) {
		super(status, message, timeStamp);
	}
	
	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldMessage> errors) {
		this.errors = errors;
	}

	//Add an error to the list as a FieldMessage
	public void addError(String fieldName, String fieldMessage) {
		errors.add(new FieldMessage(fieldName, fieldMessage));
	}
	
}
