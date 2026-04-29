package com.valorafilm.valorafilm.service.modifyusertype.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.modifyusertype.ModifyUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModifyUserTypeImpl implements ModifyUserType {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void modifyUserType(int userId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);

        if (usuarioOpt.isEmpty()){
            throw new RuntimeException("El usuario con el id " + userId + " no existe");

        }

        Usuario usuario = usuarioOpt.get();
        usuario.setTipoUsuario('A');

        usuarioRepository.save(usuario);



    }
}
