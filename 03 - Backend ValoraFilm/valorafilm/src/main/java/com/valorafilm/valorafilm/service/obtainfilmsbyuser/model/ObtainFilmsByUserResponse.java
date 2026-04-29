package com.valorafilm.valorafilm.service.obtainfilmsbyuser.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObtainFilmsByUserResponse {
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

    /*Pertenecen a la tabla de Criticas*/
    private String critica;
    private float valoracionUsuario;
    private LocalDateTime fechaCritica;

}
