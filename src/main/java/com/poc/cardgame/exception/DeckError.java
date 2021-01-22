package com.poc.cardgame.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class DeckError {
	  private Date timestamp;
	  private String message;
	  private String details;
}
