package com.poc.cardgame.service;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.poc.cardgame.model.Card;
import com.poc.cardgame.model.Deck;

@Service
public class DeckService {
	private Map<UUID, Deck> decks = new Hashtable<>();
	
	public UUID createNewDeck() {
		Deck deck = new Deck();
		UUID deckId = UUID.randomUUID();
		decks.put(deckId, deck);
		
		return deckId;
	}
	
	public Deck getDeck(UUID deckId) {
		return decks.get(deckId);
	}
	
	public Card getTopCard(Deck deck) {
		return deck.getTopCard();
	}
	
	public boolean returnCard(Deck deck, Card card) {
		return deck.returnCardToBottom(card);
	}
	
	public void shuffleDeck(Deck deck) {
		deck.shuffle();
	}
	
	public void resetDeck(Deck deck) {
		deck.initializeDeck();
		deck.shuffle();
	}
	
	public Deck removeDeck(UUID deckId) {
		return decks.remove(deckId);
	}
	
	
}
