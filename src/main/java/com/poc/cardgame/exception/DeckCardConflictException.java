package com.poc.cardgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT) 
public class DeckCardConflictException extends RuntimeException {
	public DeckCardConflictException(String message) {
		super(message);
	}

}
