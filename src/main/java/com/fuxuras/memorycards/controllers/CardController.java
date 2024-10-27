package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping()
    public String addCard(@RequestParam long deckId, Model model) {
        model.addAttribute("deckId", deckId);
        return "cards";
    }

    @PostMapping()
    public String saveCard(@RequestParam long deckId, @RequestParam String front, @RequestParam String back, Principal principal) {
        cardService.saveCard(principal.getName(),deckId,front,back);
        return "redirect:/";
    }
}
