package com.valorafilm.valorafilm.service.registerafilm.impl;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.entities.Usuario;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.database.repositories.UsuarioRepository;
import com.valorafilm.valorafilm.service.registerafilm.RegisterFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class RegisterFilmImpl implements RegisterFilm {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void registerFilm(int userId, String filmTitle, String genre, LocalDate releaseDate, String country, int duration, short minAge) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(userId);

        if (usuario.isEmpty()) {
            throw new RuntimeException("El usuario con el id " + userId + " no existe");
        }
        if (releaseDate == null) {
            throw new Exception("¡La fecha de estreno está vacía!");
        }

        Pelicula pelicula = new Pelicula();
        pelicula.setIdUsuarioAlta(userId);
        pelicula.setTitulo(filmTitle);
        pelicula.setGenero(genre);
        pelicula.setFechasEstreno(releaseDate.atStartOfDay());
        pelicula.setPaisOrigen(country);
        pelicula.setDuracion(Short.parseShort(duration +""));
        pelicula.setEdadMinima(minAge);
        pelicula.setFechaAlta(LocalDateTime.now());
        pelicula.setPortada(new byte[0]);

        peliculaRepository.save(pelicula);

    }
}
