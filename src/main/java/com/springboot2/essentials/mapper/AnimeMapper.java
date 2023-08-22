package com.springboot2.essentials.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springboot2.essentials.api.dto.AnimeDTO;
import com.springboot2.essentials.api.dto.AnimeUpdateDTO;
import com.springboot2.essentials.domain.Anime;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimeDTO animeDTO);

    public abstract Anime toAnime(AnimeUpdateDTO animeUpdateDTO);
}
