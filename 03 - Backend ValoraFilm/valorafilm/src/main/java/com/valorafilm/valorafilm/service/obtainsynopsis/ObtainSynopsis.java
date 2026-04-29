package com.valorafilm.valorafilm.service.obtainsynopsis;

import com.valorafilm.valorafilm.database.entities.Sinopsis;
import com.valorafilm.valorafilm.service.obtainsynopsis.model.ObtainSynopsisResponse;

import java.util.List;

public interface ObtainSynopsis {
    List<ObtainSynopsisResponse> obtainSynopsis();
}
