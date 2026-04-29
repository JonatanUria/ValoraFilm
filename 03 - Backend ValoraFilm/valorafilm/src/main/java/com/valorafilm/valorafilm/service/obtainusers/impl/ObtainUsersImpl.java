package com.valorafilm.valorafilm.service.obtainusers.impl;

import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.obtainusers.ObtainUsers;
import com.valorafilm.valorafilm.service.obtainusers.model.ObtainUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtainUsersImpl implements ObtainUsers {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<ObtainUsersResponse> obtainUsers() {

        List<Usuario> listUsers1 = usuarioRepository.findAll();
        List<ObtainUsersResponse> listUsers = new ArrayList<>();

        for (Usuario usuario: listUsers1) {
            ObtainUsersResponse obtainUsersResponse = new ObtainUsersResponse();
            obtainUsersResponse.setNombreUsuario(usuario.getNombreUsuario());
            obtainUsersResponse.setEmail(usuario.getEmail());
            obtainUsersResponse.setCredencial(usuario.getCredencial());
            obtainUsersResponse.setFotoPerfil(usuario.getFotoPerfil());
            obtainUsersResponse.setFechaNacimiento(usuario.getFechaNacimiento());
            obtainUsersResponse.setFechaRegistro(usuario.getFechaRegistro());
            obtainUsersResponse.setIdUsuario(usuario.getIdUsuario());
            obtainUsersResponse.setPaisOrigen(usuario.getPaisOrigen());
            obtainUsersResponse.setGenero(usuario.getGenero());
            obtainUsersResponse.setTipoUsuario(usuario.getTipoUsuario());

            listUsers.add(obtainUsersResponse);


        }

        return listUsers;




    }
}



