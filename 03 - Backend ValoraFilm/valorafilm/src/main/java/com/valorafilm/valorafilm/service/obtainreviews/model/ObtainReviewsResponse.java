package com.valorafilm.valorafilm.service.obtainreviews.model;

import com.valorafilm.valorafilm.database.entities.CriticaId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObtainReviewsResponse {

    private CriticaId id;
    private String critica;
    private float valoracionUsuario;
    private LocalDateTime fechaCritica;
}
