package com.valorafilm.valorafilm.database.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "USUARIOS")
public class    Usuario {
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private int idUsuario;

    @Column(name = "NOMBRE_USUARIO", nullable = false)
    private String nombreUsuario;

    @Column(name = "CREDENCIALES", nullable = false)
    private String credencial;

    @Column(name = "GENERO")
    private String genero;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PAIS_ORIGEN")
    private String paisOrigen;

    @Lob
    @Column(name = "FOTO_PERFIL", columnDefinition = "BLOB")
    private byte[] fotoPerfil;

    @Column(name = "TIPO_USUARIO", nullable = false)
    private char tipoUsuario;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;

}
