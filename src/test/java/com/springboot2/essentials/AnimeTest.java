package com.springboot2.essentials;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot2.essentials.domain.Anime;
import com.springboot2.essentials.repository.AnimeRepository;

@SpringBootTest
public class AnimeTest {

    @MockBean
    private AnimeRepository animeRepository;

    @Test
    public void saveAnime() {
        
        Anime animeMock = new Anime();
        animeMock.setName("Anime Test");
        Mockito.when(this.animeRepository.save(Mockito.any())).thenReturn(animeMock);

        Anime anime = new Anime();
        anime.setName("Anime Test");
        Anime animeSaved = animeRepository.save(anime);

        Assertions.assertEquals("Anime Test", animeSaved.getName());
    }

     @Test
    public void getAnime() {
        Anime anime = animeRepository.getReferenceById(1L);
        Assertions.assertEquals(anime.getId(), 1L);
    }

}