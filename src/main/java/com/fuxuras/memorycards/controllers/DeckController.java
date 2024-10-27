package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.repositories.DeckRepository;
import com.fuxuras.memorycards.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller()
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @GetMapping()
    public String index() {
        return "decks";
    }

    @PostMapping()
    public String create(@RequestParam String deckName, Principal principal) {
        deckService.createDeck(deckName,principal.getName());
        return "redirect:/";
    }



}
