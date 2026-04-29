package com.valorafilm.valorafilm.service.obtainfilms;

import com.valorafilm.valorafilm.database.entities.Pelicula;
import com.valorafilm.valorafilm.service.obtainfilms.model.ObtainFilmsResponse;

import java.util.List;

public interface ObtainFilms {
    List<ObtainFilmsResponse> obtainFilms();
}
