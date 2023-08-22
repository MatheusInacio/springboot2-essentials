package com.springboot2.essentials.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot2.essentials.domain.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findByNameLike(String name);

}
