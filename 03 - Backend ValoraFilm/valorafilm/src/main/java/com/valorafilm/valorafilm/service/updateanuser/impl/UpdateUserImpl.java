package com.valorafilm.valorafilm.service.updateanuser.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.updateanuser.UpdateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UpdateUserImpl implements UpdateUser {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void updateUser(int userId, String username, String email, String password, LocalDate birthdate) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("No existe ningún usuario con este id");
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setNombreUsuario(username);
        usuario.setEmail(email);
        String passwordHasheada = md5(password);
        usuario.setCredencial(passwordHasheada);
        usuario.setFechaNacimiento(birthdate.atStartOfDay());

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
