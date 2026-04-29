package com.valorafilm.valorafilm.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "SINOPSIS")
public class Sinopsis {
    @Id
    @Column(name = "ID_PELICULA", nullable = false)
    private int idPelicula;

    @Column(name = "SINOPSIS", nullable = false)
    private String sinopsis;




    }
