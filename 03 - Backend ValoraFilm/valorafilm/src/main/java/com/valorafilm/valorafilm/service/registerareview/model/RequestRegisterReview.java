package com.valorafilm.valorafilm.service.registerareview.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestRegisterReview {

    @NotNull
    private Integer userId;

    @NotBlank(message = "La reseña crítica es obligatoria")
    private String review;

    @NotNull(message = "Es obligatorio puntuar la película")
    private Float userScore;

}
