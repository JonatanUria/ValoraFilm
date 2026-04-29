package com.valorafilm.valorafilm.service.updateareview.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.CriticaId;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.service.updateareview.UpdateReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateReviewImpl implements UpdateReview {
    @Autowired
    private CriticaRepository criticaRepository;
    @Override
    public void updateReview(int filmId, int userId, String review, float userScore) {
        CriticaId criticaId = new CriticaId(filmId,userId);

        Optional<Critica> criticaOpt = criticaRepository.findById(criticaId);

        if (criticaOpt.isEmpty()){
            throw new RuntimeException("La crítica de la pelicula con id " + filmId + " y el usuario " + userId + " no existe");

        }

        Critica critica = criticaOpt.get();
        critica.setCritica(review);
        critica.setValoracionUsuario(userScore);

        criticaRepository.save(critica);

    }
}
