package com.poc.cardgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Card {
	 
	private Suit suit;
	private Rank rank;
}
