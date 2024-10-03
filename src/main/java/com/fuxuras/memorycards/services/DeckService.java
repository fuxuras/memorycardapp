package com.fuxuras.memorycards.services;

import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.models.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeckService {
    private final MemberService memberService;


    public List<Deck> getDecksByUsername(String name) {
        Member member = memberService.getMemberByUsername(name);
        if (member == null) {
            return null;
        }
        return member.getDecks();
    }
}
