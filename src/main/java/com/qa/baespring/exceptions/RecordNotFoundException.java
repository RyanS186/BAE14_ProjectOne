package com.qa.baespring.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Record does not exist with that ID")
public class RecordNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8451967977919402724L;
	

}
