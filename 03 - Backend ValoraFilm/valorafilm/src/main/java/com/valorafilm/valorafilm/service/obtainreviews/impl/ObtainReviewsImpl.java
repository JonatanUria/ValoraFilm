package com.valorafilm.valorafilm.service.obtainreviews.impl;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.database.repositories.CriticaRepository;
import com.valorafilm.valorafilm.service.obtainreviews.ObtainReviews;
import com.valorafilm.valorafilm.service.obtainreviews.model.ObtainReviewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ObtainReviewsImpl implements ObtainReviews {
    @Autowired
    private CriticaRepository criticaRepository;

    public List<ObtainReviewsResponse> obtainReviews() {
        List<Critica> listReviews1 = criticaRepository.findAll();
        List<ObtainReviewsResponse> listReviews = new ArrayList<>();

        for (Critica critica : listReviews1) {
            ObtainReviewsResponse obtainReviewsResponse = new ObtainReviewsResponse();
            obtainReviewsResponse.setId(critica.getId());
            obtainReviewsResponse.setCritica(critica.getCritica());
            obtainReviewsResponse.setFechaCritica(critica.getFechaCritica());
            obtainReviewsResponse.setValoracionUsuario(critica.getValoracionUsuario());

            listReviews.add(obtainReviewsResponse);
        }
        return listReviews;
    }
}
