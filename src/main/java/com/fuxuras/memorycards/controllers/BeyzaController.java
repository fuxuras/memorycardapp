package com.fuxuras.memorycards.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeyzaController {
    @GetMapping("/beyza")
    public String Beyza(){
        return "beyza";
    }
}
