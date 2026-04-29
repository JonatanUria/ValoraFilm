package com.valorafilm.valorafilm.service.updateafilm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
@Data
public class RequestUpdateFilm {


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
