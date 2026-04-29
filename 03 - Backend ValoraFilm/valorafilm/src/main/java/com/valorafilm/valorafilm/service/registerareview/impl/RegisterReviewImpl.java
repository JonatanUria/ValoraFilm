package com.valorafilm.valorafilm.service.registerareview.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.CriticaId;
import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.registerareview.RegisterReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegisterReviewImpl implements RegisterReview {
    @Autowired
    private CriticaRepository criticaRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public void registerReview(int filmId, int userId, String review, float userScore) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(filmId);
        if (pelicula.isEmpty()) {
            throw new RuntimeException("La película con el id " + filmId + " no existe");
        }

        Optional<Usuario> usuario = usuarioRepository.findById(userId);
        if (usuario.isEmpty()) {
            throw new RuntimeException("El usuario con el id " + userId + " no existe");
        }


        Critica critica = new Critica();
        CriticaId criticaId = new CriticaId(filmId, userId);


        critica.setId(criticaId);
        critica.setCritica(review);
        critica.setValoracionUsuario(userScore);
        critica.setFechaCritica(LocalDateTime.now());

        criticaRepository.save(critica);


    }
}
