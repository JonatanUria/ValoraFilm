package com.valorafilm.valorafilm.service.obtainfilms.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObtainFilmsResponse {
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
}
