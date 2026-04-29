package com.valorafilm.valorafilm.service.obtainfilmsbyuser.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.CriticaId;
import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.database.repositories.PeliculaRepository;
import com.valorafilm.valorafilm.service.obtainfilmsbyuser.ObtainFilmsByUser;
import com.valorafilm.valorafilm.service.obtainfilmsbyuser.model.ObtainFilmsByUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObtainFilmsByUserImpl implements ObtainFilmsByUser {
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private CriticaRepository criticaRepository;

    @Override
    public List<ObtainFilmsByUserResponse> obtainFilmsByUser(int userId) {
        List<Pelicula> filmsUserId = peliculaRepository.findByIdUsuario(userId);
        List<ObtainFilmsByUserResponse> listFilmsUser = new ArrayList<>();

        if (!filmsUserId.isEmpty()) {
            for (Pelicula pelicula : filmsUserId) {
                ObtainFilmsByUserResponse obtainFilmsByUserResponse = new ObtainFilmsByUserResponse();
                obtainFilmsByUserResponse.setTitulo(pelicula.getTitulo());
                obtainFilmsByUserResponse.setDuracion(pelicula.getDuracion());
                obtainFilmsByUserResponse.setGenero(pelicula.getGenero());
                obtainFilmsByUserResponse.setEdadMinima(pelicula.getEdadMinima());
                obtainFilmsByUserResponse.setPortada(pelicula.getPortada());
                obtainFilmsByUserResponse.setPaisOrigen(pelicula.getPaisOrigen());
                obtainFilmsByUserResponse.setFechasEstreno(pelicula.getFechasEstreno());
                obtainFilmsByUserResponse.setIdPelicula(pelicula.getIdPelicula());
                obtainFilmsByUserResponse.setValoracionMediaUsuario(pelicula.getValoracionMediaUsuario());
                obtainFilmsByUserResponse.setValoracionMediaCriticos(pelicula.getValoracionMediaCriticos());
                obtainFilmsByUserResponse.setFechaAlta(pelicula.getFechaAlta());

                CriticaId criticaId = new CriticaId(pelicula.getIdPelicula(), userId);
                Optional<Critica> reviewUserOpt = criticaRepository.findById(criticaId);

                if (!reviewUserOpt.isEmpty()) {
                    Critica reviewUser = reviewUserOpt.get();
                    obtainFilmsByUserResponse.setCritica(reviewUser.getCritica());
                    obtainFilmsByUserResponse.setValoracionUsuario(reviewUser.getValoracionUsuario());
                    obtainFilmsByUserResponse.setFechaCritica(reviewUser.getFechaCritica());
                }

                listFilmsUser.add(obtainFilmsByUserResponse);

            }

        }
        return listFilmsUser;
    }
}



