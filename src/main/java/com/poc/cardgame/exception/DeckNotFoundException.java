package com.poc.cardgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND) 
public class DeckNotFoundException extends RuntimeException {
	public DeckNotFoundException(String message) {
		super(message);
	}

}
