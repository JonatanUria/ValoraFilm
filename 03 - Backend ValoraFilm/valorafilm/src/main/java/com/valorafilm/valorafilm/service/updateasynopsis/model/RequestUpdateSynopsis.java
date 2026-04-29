package com.valorafilm.valorafilm.service.updateasynopsis.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestUpdateSynopsis {
    @NotBlank(message = "La sinopsis es obligatoria")
    private String synopsis;
}
