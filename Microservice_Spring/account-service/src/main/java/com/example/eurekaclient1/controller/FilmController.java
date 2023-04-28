package com.example.eurekaclient1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FilmController {

    @GetMapping("/films")
    public String getFilms(){
        return "show all films";
    }
}
