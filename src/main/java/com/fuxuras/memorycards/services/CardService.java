package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Card;
import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final DeckService deckService;
    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }


    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    public Card updateCard(Long id, Card card) {
        Card existingCard = cardRepository.findById(id).orElse(null);
        if (existingCard == null) {
            return null;
        }
        existingCard.setFront(card.getFront());
        existingCard.setBack(card.getBack());
        return cardRepository.save(existingCard);
    }

    public void saveCard(String name, long deckId, String front, String back) {
        Deck deck = deckService.getById(deckId);
        if(deck.getOwner().getUsername().equals(name)) {
            Card card = new Card();
            card.setDeck(deck);
            card.setBack(back);
            card.setFront(front);
            cardRepository.save(card);
        }


    }


}
