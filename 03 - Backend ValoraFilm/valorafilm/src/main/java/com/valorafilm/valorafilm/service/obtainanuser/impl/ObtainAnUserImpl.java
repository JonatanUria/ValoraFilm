package com.valorafilm.valorafilm.service.obtainanuser.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.obtainanuser.ObtainAnUser;
import com.valorafilm.valorafilm.service.obtainanuser.model.ObtainUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObtainAnUserImpl implements ObtainAnUser {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ObtainUserResponse obtainUser(int userId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("El usuario con el id " + userId + " no existe");
        }

        Usuario usuario = usuarioOpt.get();
        ObtainUserResponse obtainUserResponse = new ObtainUserResponse();
        obtainUserResponse.setNombreUsuario(usuario.getNombreUsuario());
        obtainUserResponse.setGenero(usuario.getGenero());
        obtainUserResponse.setEmail(usuario.getEmail());
        obtainUserResponse.setPaisOrigen(usuario.getPaisOrigen());
        obtainUserResponse.setFotoPerfil(usuario.getFotoPerfil());
        obtainUserResponse.setTipoUsuario(usuario.getTipoUsuario());
        obtainUserResponse.setFechaRegistro(usuario.getFechaRegistro());
        obtainUserResponse.setFechaNacimiento(usuario.getFechaNacimiento());

        return obtainUserResponse;
    }
}
