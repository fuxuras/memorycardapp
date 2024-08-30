package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Card;
import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.repositories.DeckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final DeckRepository deckRepository;

    public Deck getDeckById(Long id) {
        return deckRepository.findById(id).orElse(null);
    }

    public Deck saveDeck(Deck deck) {
        return deckRepository.save(deck);
    }

    public void deleteDeck(Long id) {
        deckRepository.deleteById(id);
    }

    public Deck updateDeck(Long id, Deck deck) {
        Deck existingDeck = deckRepository.findById(id).orElse(null);
        if (existingDeck == null) {
            return null;
        }
        existingDeck.setName(deck.getName());
        existingDeck.setCards(deck.getCards());
        return deckRepository.save(existingDeck);
    }

    public void addCardToDeck(Long deckId, Card card) {
        Deck deck = deckRepository.findById(deckId).orElse(null);
        if (deck == null) {
            return;
        }
        deck.getCards().add(card);
    }
}
