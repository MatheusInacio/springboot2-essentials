package com.springboot2.essentials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot2.essentials.domain.Anime;

public interface AnimeRepository  extends JpaRepository<Anime, Long>{

    

}
