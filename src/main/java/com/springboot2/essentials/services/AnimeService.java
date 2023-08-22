package com.springboot2.essentials.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot2.essentials.api.dto.AnimeDTO;
import com.springboot2.essentials.api.dto.AnimeUpdateDTO;
import com.springboot2.essentials.domain.Anime;
import com.springboot2.essentials.exception.BadRequestException;
import com.springboot2.essentials.mapper.AnimeMapper;
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
                .orElseThrow(() -> new BadRequestException("Anime not found"));
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByNameLike("%" + name + "%");
    }

    @Transactional
    public Anime save(AnimeDTO anime) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(anime));
    }

    public void delete(long id) {
        animeRepository.deleteById(id);
    }

    @Transactional
    public Anime update(AnimeUpdateDTO animeUpdateDTO) {
        Anime savedAnime = findById(animeUpdateDTO.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animeUpdateDTO);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
        return findById(savedAnime.getId());
    }

}
