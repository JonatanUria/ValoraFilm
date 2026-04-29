package com.valorafilm.valorafilm.service.deleteareview.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.entities.CriticaId;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.service.deleteareview.DeleteReview;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DeleteReviewImpl implements DeleteReview {
    @Autowired
    private CriticaRepository criticaRepository;

    @Override
    public void deleteReview(int filmId, int userId) {
        CriticaId criticaId = new CriticaId(filmId, userId);
        Optional<Critica> criticaOpt = criticaRepository.findById(criticaId);

        if (criticaOpt.isEmpty()) {
            throw new RuntimeException("La crítica de la pelicula con id " + filmId + " del usuario con id " + userId + " no existe");
        } else {
            criticaRepository.delete(criticaOpt.get());


        }

    }
}

