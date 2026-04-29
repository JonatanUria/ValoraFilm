package com.valorafilm.valorafilm.service.registerasynopsis.impl;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import com.valorafilm.valorafilm.service.registerasynopsis.RegisterSynopsis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterSynopsisImpl implements RegisterSynopsis {
    @Autowired
    private SinopsisRepository sinopsisRepository;
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public void registerSynopsis(int filmId, String synopsis) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(filmId);

        if (pelicula.isEmpty()) {
            throw new RuntimeException("La película con id " + filmId + " no existe");
        }

        Sinopsis sinopsis = new Sinopsis();
        sinopsis.setIdPelicula(filmId);
        sinopsis.setSinopsis(synopsis);

        sinopsisRepository.save(sinopsis);



    }
}
