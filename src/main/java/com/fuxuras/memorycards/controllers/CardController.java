package com.fuxuras.memorycards.controllers;

import com.fuxuras.memorycards.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;


    @PutMapping()
    public void updadteOccurrences(@RequestParam long id, @RequestBody int occurrences) {
        cardService.updateOccurrences(id, occurrences);
    }

}
