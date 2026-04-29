package com.valorafilm.valorafilm.service.deleteafilm.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import com.valorafilm.valorafilm.service.deleteafilm.DeleteFilm;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DeleteFilmImpl implements DeleteFilm {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private SinopsisRepository sinopsisRepository;
    @Autowired
    private CriticaRepository criticaRepository;

    @Override
    @Transactional
    public void deleteFilm(int filmId) {
        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(filmId);
        if (peliculaOpt.isEmpty()) {
            throw new RuntimeException("La pelicula con el id " + filmId + " no existe");
        }

        Optional<Sinopsis> sinopsisOpt = sinopsisRepository.findById(filmId);
        if (sinopsisOpt.isPresent()) {
            sinopsisRepository.delete(sinopsisOpt.get());
            log.info("Sinopsis borrada correctamente");
        }

        List<Critica> criticasPeliculasOpt = criticaRepository.findByIdPelicula(filmId);
        if (!criticasPeliculasOpt.isEmpty()) {
            log.info("Se van a borrar " + criticasPeliculasOpt.size() + " críticas de la película" + filmId);
            criticaRepository.deleteAll(criticasPeliculasOpt);
            log.info("Se han borrado correctamente.");
        }

        peliculaRepository.delete(peliculaOpt.get());

    }
}
