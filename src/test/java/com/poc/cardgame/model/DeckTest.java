package com.poc.cardgame.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	private Deck deck = new Deck();
	
	@Test
	void testCreate() {
		assertTrue(deck.getDeckSize() == 52, "Deck size is not eqaul to 52");
	}
	
	@Test
	void testGetTop() {
		Card card = deck.getTopCard();
		assertTrue(card.getSuit().equals(Suit.HEARTS) && card.getRank().equals(Rank.TWO), "Top card is not TWO of HEARTS");
		assertTrue(deck.getDeckSize() == 51, "Deck size should be 51 after retrieving top card");
		card = deck.getTopCard();
		assertTrue(card.getSuit().equals(Suit.HEARTS) && card.getRank().equals(Rank.THREE), "Top card is not THREE of HEARTS");
		assertTrue(deck.getDeckSize() == 50, "Deck size should be 50 after retrieving another card");
	}
	
	@Test
	void testReturnCard() {
		Card card = new Card(Suit.HEARTS, Rank.TWO);
		assertFalse(deck.returnCardToBottom(card), "Card should have not been added");
		deck.getTopCard();
		deck.getTopCard();
		assertTrue(deck.returnCardToBottom(card), "Card should have been added");
		assertTrue(deck.getDeckSize() == 51, "Deck size should be 51 after adding the card");
		assertFalse(deck.returnCardToBottom(card), "Card should not have been added");
		assertTrue(deck.getDeckSize() == 51, "Deck size should be 51 after card failed to be added back");
	}	

}
