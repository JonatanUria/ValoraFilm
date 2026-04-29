package com.valorafilm.valorafilm.service.registerafilm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class RequestRegisterFilm {

    @NotNull(message = "El userId es obligatorio")
    private Integer userId;

    @NotBlank(message = "El título de la película es obligatorio")
    private String filmTitle;

    @NotBlank(message = "El género de la película es obligatorio")
    private String genre;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotBlank(message = "El país de la película es obligatorio")
    private String country;

    @NotNull(message = "La duración de la película es obligatoria")
    private Short duration;

    @NotNull(message = "La edad mínima es obligatoria")
    private Short minAge;
}
