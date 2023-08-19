package com.springboot2.essentials.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.essentials.domain.Anime;
import com.springboot2.essentials.util.DateUtils;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("anime")
@Log4j2
public class AnimeController {

    @Autowired
    private DateUtils dateUtils;

    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtils.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("Cavaleiros do Zodiaco"), new Anime("Dragon Ball Z"), new Anime("Berserk"));
    }

}
