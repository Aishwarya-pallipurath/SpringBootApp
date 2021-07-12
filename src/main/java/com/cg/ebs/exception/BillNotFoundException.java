package com.cg.ebs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BillNotFoundException {
	private static final long serialVersionUID = 1L;

	public BillNotFoundException(String msg) {
		super();
	}

}
