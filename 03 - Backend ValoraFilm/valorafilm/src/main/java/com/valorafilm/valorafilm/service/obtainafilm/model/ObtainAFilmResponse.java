package com.valorafilm.valorafilm.service.obtainafilm.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObtainAFilmResponse {
    private int idPelicula;
    private String titulo;
    private byte[] portada;
    private String genero;
    private LocalDateTime fechasEstreno;
    private String paisOrigen;
    private short duracion;
    private short edadMinima;
    private float valoracionMediaUsuario;
    private float valoracionMediaCriticos;
    private LocalDateTime fechaAlta;
    private int idUsuarioAlta;

    // Viene de la tabla de Sinopsis
    private String sinopsis;

}
