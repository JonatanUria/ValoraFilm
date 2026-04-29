package com.valorafilm.valorafilm.database.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PELICULAS")
public class Pelicula {
    @Id
    @Column(name = "ID_PELICULA")
    private int idPelicula;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Lob
    @Column(name = "PORTADA", columnDefinition = "BLOB", nullable = false)
    private byte[] portada;


    @Column(name = "GENERO", nullable = false)
    private String genero;

    @Column(name = "FECHA_ESTRENO", nullable = false)
    private LocalDateTime fechasEstreno;

    @Column(name = "PAIS_ORIGEN", nullable = false)
    private String paisOrigen;

    @Column(name = "DURACION", nullable = false)
    private short duracion;

    @Column(name = "EDAD_MINIMA", nullable = false)
    private short edadMinima;

    @Column(name = "VALORACION_MEDIA_USUARIO", nullable = false)
    private float valoracionMediaUsuario;

    @Column(name = "VALORACION_CRITICOS", nullable = false)
    private float valoracionMediaCriticos;

    @Column(name = "FECHA_ALTA", nullable = false)
    private LocalDateTime fechaAlta;


    @Column(name = "ID_USUARIO_ALTA", nullable = false)
    private int idUsuarioAlta;
}


