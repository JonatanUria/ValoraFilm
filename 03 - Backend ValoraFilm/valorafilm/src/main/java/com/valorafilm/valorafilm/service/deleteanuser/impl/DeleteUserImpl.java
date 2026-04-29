package com.valorafilm.valorafilm.service.deleteanuser.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.deleteanuser.DeleteUser;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DeleteUserImpl implements DeleteUser {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CriticaRepository criticaRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    @Transactional
    public void deleteUser(int userId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(userId);
        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("El usuario con el id " + userId + " no existe");
        }

        List<Critica> criticasUsuarioOpt = criticaRepository.findByIdUsuario(userId);
        if (!criticasUsuarioOpt.isEmpty()) {
            criticaRepository.deleteAll(criticasUsuarioOpt);

            log.info("Las criticas del usuario con id " + userId + " han sido eliminadas correctamente.");


        }


        usuarioRepository.delete(usuarioOpt.get());


    }
}
