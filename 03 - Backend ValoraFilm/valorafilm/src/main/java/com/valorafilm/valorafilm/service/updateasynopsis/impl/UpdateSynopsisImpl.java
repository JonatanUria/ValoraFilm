package com.valorafilm.valorafilm.service.updateasynopsis.impl;

import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import com.valorafilm.valorafilm.service.updateasynopsis.UpdateSynopsis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateSynopsisImpl implements UpdateSynopsis {
    @Autowired
    private SinopsisRepository sinopsisRepository;
    @Override
    public void updateSynopsis(int filmId, String synopsis) {
        Optional<Sinopsis> sinopsisOpt = sinopsisRepository.findById(filmId);
        if (sinopsisOpt.isEmpty()) {
            throw new RuntimeException("La sinopsis de la película con el id " + filmId + " no existe");

        }

        Sinopsis sinopsis = sinopsisOpt.get();
        sinopsis.setSinopsis(synopsis);

        sinopsisRepository.save(sinopsis);



    }
}
