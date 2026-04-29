package com.valorafilm.valorafilm.service.registeranuser.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.registeranuser.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class RegisterUserImpl implements RegisterUser {
    @Autowired
    private UsuarioRepository usuarioRepository;



    @Override
    public void registerUser(String username, String email, String password, LocalDate birthdate) {
        Usuario usuario = new Usuario();

        usuario.setNombreUsuario(username);
        usuario.setEmail(email);
        String passwordHasheada = md5(password);
        usuario.setCredencial(passwordHasheada);
        usuario.setFechaNacimiento(birthdate.atStartOfDay());
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setTipoUsuario('G');


        usuarioRepository.save(usuario);

    }



    public String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

