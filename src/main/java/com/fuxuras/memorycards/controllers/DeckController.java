package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.models.Deck;
import com.fuxuras.memorycards.repositories.DeckRepository;
import com.fuxuras.memorycards.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller()
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @GetMapping()
    public String index(Model model, Principal principal) {
        List<Deck> decks = deckService.getDecksByUsername(principal.getName());
        model.addAttribute("decks",decks);
        return "decks";
    }

    @PostMapping()
    public String create(@RequestParam String deckName, Principal principal) {
        deckService.createDeck(deckName,principal.getName());
        return "redirect:/";
    }

    @DeleteMapping("{deckId}")
    public void delete(@PathVariable Long deckId, Principal principal) {
        deckService.deleteDeck(deckId,principal.getName());
    }



}
