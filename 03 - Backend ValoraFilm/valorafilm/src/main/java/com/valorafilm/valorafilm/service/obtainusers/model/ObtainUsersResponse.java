package com.valorafilm.valorafilm.service.obtainusers.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ObtainUsersResponse {
    private int idUsuario;
    private String nombreUsuario;
    private String credencial;
    private String genero;
    private String email;
    private String paisOrigen;
    private byte[] fotoPerfil;
    private char tipoUsuario;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNacimiento;
}
