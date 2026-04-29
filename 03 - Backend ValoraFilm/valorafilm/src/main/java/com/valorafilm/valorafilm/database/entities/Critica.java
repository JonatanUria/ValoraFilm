package com.valorafilm.valorafilm.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "CRITICAS_PELICULAS")
public class Critica {
    @EmbeddedId
    private CriticaId id;

    @Column(name = "CRITICA", nullable = false)
    private String critica;

    @Column(name = "VALORACION_USUARIO", nullable = false)
    private float valoracionUsuario;

    @Column(name = "FECHA_CRITICA", nullable = false)
    private LocalDateTime fechaCritica;

}
