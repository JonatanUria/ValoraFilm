package com.valorafilm.valorafilm.service.updateafilm.impl;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.service.updateafilm.UpdateFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UpdateFilmImpl implements UpdateFilm {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Override
    public void updateFilm(int filmId, String filmTitle, String genre, LocalDate releaseDate, String country, short duration, short minAge) {
        Optional<Pelicula> peliculaOpt = peliculaRepository.findById(filmId);

        if (peliculaOpt.isEmpty()){
            throw new RuntimeException("La película con el id " + filmId + " no existe");
        }

        Pelicula pelicula = peliculaOpt.get();
        pelicula.setTitulo(filmTitle);
        pelicula.setGenero(genre);
        pelicula.setFechasEstreno(releaseDate.atStartOfDay());
        pelicula.setPaisOrigen(country);
        pelicula.setDuracion(duration);
        pelicula.setEdadMinima(minAge);

        peliculaRepository.save(pelicula);


    }
}
