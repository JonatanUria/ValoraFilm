package com.valorafilm.valorafilm.service.obtainafilm.impl;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import com.valorafilm.valorafilm.service.obtainafilm.ObtainAFilm;
import com.valorafilm.valorafilm.service.obtainafilm.model.ObtainAFilmResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ObtainAFilmImpl implements ObtainAFilm {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private SinopsisRepository sinopsisRepository;

    @Override
    public ObtainAFilmResponse obtainFilm(int idFilm) {

        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(idFilm);
        if (peliculaOpt.isEmpty()) {
            throw new RuntimeException("La pelicula con el id " + idFilm + " no existe");
        }

        Pelicula pelicula = peliculaOpt.get();


        ObtainAFilmResponse film = new ObtainAFilmResponse();
        film.setIdPelicula(pelicula.getIdPelicula());
        film.setTitulo(pelicula.getTitulo());
        film.setGenero(pelicula.getGenero());
        film.setPortada(pelicula.getPortada());
        film.setDuracion(pelicula.getDuracion());
        film.setFechaAlta(pelicula.getFechaAlta());
        film.setEdadMinima(pelicula.getEdadMinima());
        film.setFechasEstreno(pelicula.getFechasEstreno());
        film.setPaisOrigen(pelicula.getPaisOrigen());
        film.setIdUsuarioAlta(pelicula.getIdUsuarioAlta());
        film.setValoracionMediaCriticos(pelicula.getValoracionMediaCriticos());
        film.setValoracionMediaUsuario(pelicula.getValoracionMediaUsuario());

        Optional<Sinopsis> sinopsisOpt = sinopsisRepository.findById(idFilm);
        if (sinopsisOpt.isPresent()) {
            Sinopsis sinopsis = sinopsisOpt.get();
            film.setSinopsis(sinopsis.getSinopsis());
        }

        return film;


    }
}
