package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class AppController {

    private final DeckService deckService;


    @GetMapping
    public String app(Model model) {
        Deck deck = deckService.getDeckById(1L);
        model.addAttribute("deck", deck);
        return "flashcards";
    }
}
