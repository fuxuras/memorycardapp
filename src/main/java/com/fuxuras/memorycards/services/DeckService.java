package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.models.Member;
import com.fuxuras.memorycards.repositories.DeckRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final MemberService memberService;
    private final DeckRepository deckRepository;

    public List<Deck> getDecksByUsername(String name) {
        Member member = memberService.getMemberByUsername(name);
        if (member == null) {
            return null;
        }
        return member.getDecks();
    }

    public void createDeck(String deckName, String name) {
        Member member = memberService.getMemberByUsername(name);
        Deck deck = new Deck();
        deck.setName(deckName);
        deck.setOwner(member);
        deckRepository.save(deck);
    }

    public Deck getById(long deckId) {
        return deckRepository.findById(deckId).orElse(null);
    }
}
