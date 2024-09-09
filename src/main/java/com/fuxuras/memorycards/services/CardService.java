package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Card;
import com.fuxuras.memorycards.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
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
        existingCard.setOccurrences(card.getOccurrences());
        return cardRepository.save(existingCard);
    }

    public void updateOccurrences(long id, int occurrences) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            return;
        }
        card.setOccurrences(occurrences);
        cardRepository.save(card);
    }
}
