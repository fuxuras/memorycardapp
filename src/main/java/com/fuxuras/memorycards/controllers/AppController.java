package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AppController {

    private final DeckService deckService;


    @GetMapping
    public String app(Model model, Principal principal) {
        List<Deck> decks = deckService.getDecksByUsername(principal.getName());
        model.addAttribute("decks", decks);
        return "flashcards";
    }
}
