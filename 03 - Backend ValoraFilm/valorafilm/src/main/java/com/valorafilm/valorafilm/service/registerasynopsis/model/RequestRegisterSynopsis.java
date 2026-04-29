package com.valorafilm.valorafilm.service.registerasynopsis.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestRegisterSynopsis {

    @NotBlank(message = "La sinopsis es obligatoria")
    private String synopsis;
}

