package com.springboot2.essentials.domain;

/**
 * Anime
 */
public class Anime {

    private String name;

    public Anime(String name) {
        this.name = name;
    }

    public Anime() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}