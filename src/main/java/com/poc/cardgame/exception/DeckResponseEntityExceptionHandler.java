package com.poc.cardgame.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class DeckResponseEntityExceptionHandler {
	@ExceptionHandler(DeckNotFoundException.class)
	public final ResponseEntity<DeckError> handleDeckNotFoundException(DeckNotFoundException ex, WebRequest request) {
		DeckError deckError = new DeckError(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(deckError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DeckEmptyException.class)
	public final ResponseEntity<DeckError> handleDeckEmptyException(DeckEmptyException ex, WebRequest request) {
		DeckError deckError = new DeckError(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(deckError, HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(DeckCardConflictException.class)
	public final ResponseEntity<DeckError> handleDeckCardConfictException(DeckCardConflictException ex, WebRequest request) {
		DeckError deckError = new DeckError(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(deckError, HttpStatus.CONFLICT);
	}	
}
