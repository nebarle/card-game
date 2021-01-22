package com.poc.cardgame.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.cardgame.exception.DeckCardConflictException;
import com.poc.cardgame.exception.DeckEmptyException;
import com.poc.cardgame.exception.DeckNotFoundException;
import com.poc.cardgame.model.Card;
import com.poc.cardgame.model.Deck;
import com.poc.cardgame.service.DeckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/deck")
@Api(value="Decks", description="Operations pertaining to deck of cards")
public class DeckController {

	@Autowired
	private DeckService deckService;
	
	@PostMapping
	@ApiOperation(value = "Creates a new deck of unshuffled cards and returns the generated deck Id of the newly created deck to "
			+ "be used for succeeding operations", response = UUID.class)
	public UUID createNewDeck() {
		return deckService.createNewDeck();
	}
	
	@GetMapping("{deckId}/card")
	@ApiOperation(value = "Retrives the top card on the deck using the supplied deck Id. It will return an error if the deck Id "
			+ "does not exist or all of the cards on the deck had been already dealt. The deck Id should be in valid UUID format"
			, response = Card.class)	
	public Card getCardByDeckId(@PathVariable("deckId") UUID deckId) {
		Deck deck = deckService.getDeck(deckId);
		
		if (deck == null) 
			throw new DeckNotFoundException("Deck with deckId " + deckId + " does not exist");
		
		Card card = deckService.getTopCard(deck);
		
		if (card == null)
			throw new DeckEmptyException("Deck with deckId " + deckId + " is empty");
		
		return card;
	}
	
	@PutMapping(path="{deckId}/card", consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Puts the specified card back to the bottom of the deck using the supplied deck Id. It will return an "
			+ "error if the deck Id does not exist or if the card already exists on the deck. The deck Id should be in valid UUID format")		
	public void putCardBackByDeckId(@PathVariable("deckId") UUID deckId, @RequestBody Card card) {
		Deck deck = deckService.getDeck(deckId);
		
		if (deck == null) 
			throw new DeckNotFoundException("Deck with deckId " + deckId + " does not exist");
		
		if (!deckService.returnCard(deck, card)) 
			throw new DeckCardConflictException("Deck with deckId " + deckId + " already contains that card");
		
		
	}
	
	@PostMapping("{deckId}/shuffle")
	@ApiOperation(value = "Shuffles the deck using the supplied deck Id. It will return an error if the deck Id does not exist. " + 
			"The deck Id should be in valid UUID format")		
	public void shuffleByDeckId(@PathVariable("deckId") UUID deckId) {
		Deck deck = deckService.getDeck(deckId);
		
		if (deck == null) 
			throw new DeckNotFoundException("Deck with deckId " + deckId + " does not exist");
		
		deckService.shuffleDeck(deck);
	}
	
	@PostMapping("{deckId}/reset")
	@ApiOperation(value = "Resets the deck (all cards present and shuffled) using the supplied deck Id. "
		+ "It will return an error if the deck Id does not exist. The deck Id should be in valid UUID format")	
	public void resetByDeckId(@PathVariable("deckId") UUID deckId) {
		Deck deck = deckService.getDeck(deckId);
		
		if (deck == null) 
			throw new DeckNotFoundException("Deck with deckId " + deckId + " does not exist");
		
		deckService.resetDeck(deck);
	}
	
	@DeleteMapping("{deckId}")
	@ApiOperation(value = "Deletes the instance of the deck based on the supplied deck Id. This cannot be undone. It will " 
			+ "return an error if the deck Id does not exist. The deck Id should be in valid UUID format")		
	public void removeByDeckId(@PathVariable("deckId") UUID deckId) {
		Deck deck = deckService.removeDeck(deckId);
		
		if (deck == null) 
			throw new DeckNotFoundException("Deck with deckId " + deckId + " does not exist");
	}	
}
