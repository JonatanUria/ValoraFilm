package com.valorafilm.valorafilm.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriticaId implements Serializable {

    @Column(name = "ID_PELICULA")
    private int idPelicula;

    @Column(name = "ID_USUARIO")
    private int idUsuario;
}
