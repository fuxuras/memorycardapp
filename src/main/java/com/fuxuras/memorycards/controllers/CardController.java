package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.models.Card;
import com.fuxuras.memorycards.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/decks/{deckId}/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping()
    public String addCard(@PathVariable long deckId, Model model) {
        List<Card> cards = cardService.getCardsOfDeck(deckId);
        model.addAttribute("cards", cards);
        model.addAttribute("deckId", deckId);
        return "cards";
    }

    @PostMapping()
    public String saveCard(@PathVariable long deckId, @RequestParam String front, @RequestParam String back, Principal principal) {
        cardService.saveCard(principal.getName(),deckId,front,back);
        return "redirect:/";
    }
    @DeleteMapping("{cardId}")
    public void deleteCard(@PathVariable long deckId,@PathVariable long cardId, Principal principal) {
        cardService.deleteCard(deckId,cardId,principal.getName());
    }
}
