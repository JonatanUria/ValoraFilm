package com.valorafilm.valorafilm.service.obtainanuser.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ObtainUserResponse {
    private String nombreUsuario;
    private String genero;
    private String email;
    private String paisOrigen;
    private byte[] fotoPerfil;
    private char tipoUsuario;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNacimiento;
}
