package com.valorafilm.valorafilm.service.obtainfilmsbyuser;

import com.valorafilm.valorafilm.service.obtainfilmsbyuser.model.ObtainFilmsByUserResponse;

import java.util.List;

public interface ObtainFilmsByUser {
    List<ObtainFilmsByUserResponse> obtainFilmsByUser(int userId);
}
