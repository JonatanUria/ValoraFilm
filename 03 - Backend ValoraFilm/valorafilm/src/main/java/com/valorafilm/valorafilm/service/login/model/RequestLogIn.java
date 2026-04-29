package com.valorafilm.valorafilm.service.login.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestLogIn {
    @NotBlank(message = "el nombre es obligatorio")
    private String username;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
