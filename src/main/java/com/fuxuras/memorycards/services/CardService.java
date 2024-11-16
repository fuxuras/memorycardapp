package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Card;
import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final DeckService deckService;
    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
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
    public List<Card> getCardsOfDeck(Long deckId) {
        return deckService.getById(deckId).getCards();
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


    public void deleteCard(long deckId, long cardId, String name) {
        Deck deck = deckService.getById(deckId);
        if(deck.getOwner().getUsername().equals(name)) {
            Card card = cardRepository.findById(cardId).orElse(null);
            if(card != null) {
                if (card.getDeck().equals(deck)) {
                    cardRepository.delete(card);
                }
            }
        }
    }
}
