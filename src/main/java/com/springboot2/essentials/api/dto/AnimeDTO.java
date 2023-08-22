package com.springboot2.essentials.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnimeDTO {
    
    @NotNull(message = "The anime cannot be null")
    @NotEmpty(message = "The anime cannot be empty")
    public String name;

}
