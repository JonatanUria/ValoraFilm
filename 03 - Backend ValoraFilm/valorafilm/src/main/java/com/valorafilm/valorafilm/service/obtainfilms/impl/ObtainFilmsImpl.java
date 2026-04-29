package com.valorafilm.valorafilm.service.obtainfilms.impl;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.service.obtainfilms.ObtainFilms;
import com.valorafilm.valorafilm.service.obtainfilms.model.ObtainFilmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObtainFilmsImpl implements ObtainFilms {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<ObtainFilmsResponse> obtainFilms() {
        List<Pelicula> listFilms1 = peliculaRepository.findAll();
        List<ObtainFilmsResponse> listFilms = new ArrayList<>();

        for (Pelicula pelicula : listFilms1) {
            ObtainFilmsResponse obtainFilmsResponse = new ObtainFilmsResponse();
            obtainFilmsResponse.setTitulo(pelicula.getTitulo());
            obtainFilmsResponse.setGenero(pelicula.getGenero());
            obtainFilmsResponse.setDuracion(pelicula.getDuracion());
            obtainFilmsResponse.setPortada(pelicula.getPortada());
            obtainFilmsResponse.setFechaAlta(pelicula.getFechaAlta());
            obtainFilmsResponse.setEdadMinima(pelicula.getEdadMinima());
            obtainFilmsResponse.setFechasEstreno(pelicula.getFechasEstreno());
            obtainFilmsResponse.setIdPelicula(pelicula.getIdPelicula());
            obtainFilmsResponse.setPaisOrigen(pelicula.getPaisOrigen());
            obtainFilmsResponse.setIdUsuarioAlta(pelicula.getIdUsuarioAlta());
            obtainFilmsResponse.setValoracionMediaCriticos(pelicula.getValoracionMediaCriticos());
            obtainFilmsResponse.setValoracionMediaUsuario(pelicula.getValoracionMediaUsuario());

            listFilms.add(obtainFilmsResponse);

        }
        return listFilms;
    }
}
