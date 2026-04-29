package com.valorafilm.valorafilm.service.updateanuser.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class RequestUpdateUser {
    @NotBlank(message = "El nombre es obligatorio")
    private String username;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe de ser un email válio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min =8, message= "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;
}
