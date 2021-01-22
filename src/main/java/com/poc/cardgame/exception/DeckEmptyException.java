package com.poc.cardgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NO_CONTENT) 
public class DeckEmptyException extends RuntimeException {
	public DeckEmptyException(String message) {
		super(message);
	}

}
