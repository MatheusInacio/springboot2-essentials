package com.springboot2.essentials.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot2.essentials.api.dto.AnimeDTO;
import com.springboot2.essentials.api.dto.AnimeUpdateDTO;
import com.springboot2.essentials.domain.Anime;
import com.springboot2.essentials.repository.AnimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Anime findById(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(AnimeDTO anime) {
        return animeRepository.save(Anime.builder().name(anime.getName()).build());
    }

    public void delete(long id) {
        animeRepository.deleteById(id);
    }

    public Anime update(AnimeUpdateDTO anime) {
        Anime savedAnime = findById(anime.getId());
        animeRepository.save(Anime.builder().id(savedAnime.getId()).name(anime.getName()).build());
        return findById(savedAnime.getId());
    }

}
