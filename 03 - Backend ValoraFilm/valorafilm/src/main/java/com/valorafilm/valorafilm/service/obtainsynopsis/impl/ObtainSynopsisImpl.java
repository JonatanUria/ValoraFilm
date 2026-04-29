package com.valorafilm.valorafilm.service.obtainsynopsis.impl;

import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.database.repositories.SinopsisRepository;
import com.valorafilm.valorafilm.service.obtainsynopsis.ObtainSynopsis;
import com.valorafilm.valorafilm.service.obtainsynopsis.model.ObtainSynopsisResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ObtainSynopsisImpl implements ObtainSynopsis {
    @Autowired
    private SinopsisRepository sinopsisRepository;
    @Override
    public List<ObtainSynopsisResponse> obtainSynopsis() {
        List<Sinopsis> listSynopsis1 = sinopsisRepository.findAll();
        List<ObtainSynopsisResponse> listSynopsis = new ArrayList<>();

        for (Sinopsis sinopsis : listSynopsis1) {
            ObtainSynopsisResponse obtainSynopsisResponse = new ObtainSynopsisResponse();
            obtainSynopsisResponse.setIdPelicula(sinopsis.getIdPelicula());
            obtainSynopsisResponse.setSinopsis(sinopsis.getSinopsis());

            listSynopsis.add(obtainSynopsisResponse);

        }
        return listSynopsis;
    }
}
