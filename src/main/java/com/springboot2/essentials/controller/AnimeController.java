package com.springboot2.essentials.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.essentials.domain.Anime;

@RestController
@RequestMapping("anime")
public class AnimeController {

    @GetMapping(path = "list")
    public List<Anime> list() {
        return List.of(new Anime("Cavaleiros do Zodiaco"), new Anime("Dragon Ball Z"), new Anime("Berserk"));
    }

}
