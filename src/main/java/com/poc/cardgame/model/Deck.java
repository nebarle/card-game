package com.poc.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Deck {
	Logger logger = LoggerFactory.getLogger(Deck.class);

	private List<Card> deckOfCards;
	
	public Deck() {
		initializeDeck();
	}
	
	public void initializeDeck() {
		deckOfCards = new ArrayList<>();
		
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				logger.info(card.toString());
				deckOfCards.add(card);
			}
		}
		
	}
	
	public Card getTopCard() {
		Card card = null;
		
		logger.info("deckOfCards.size() ==> " + deckOfCards.size());
		
		if (deckOfCards.size() > 0)
			card = deckOfCards.remove(0);

		logger.info("top card ==> " + card);
		return card;
	}
	
	public boolean returnCardToBottom(Card card) {
		if (this.cardExists(card)) return false;
		
		return deckOfCards.add(card);
	}
	
	public void shuffle() {
	    Collections.shuffle(deckOfCards);
	}
	
	public boolean cardExists(Card card) {
		return deckOfCards.stream().anyMatch(c -> c.getSuit().equals(card.getSuit()) && c.getRank().equals(card.getRank()));
	}
	
	public int getDeckSize() {
		return deckOfCards.size();
	}
}
