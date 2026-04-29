package com.valorafilm.valorafilm.service.updateafilm;

import java.time.LocalDate;

public interface UpdateFilm {
    void updateFilm(int filmId, String filmTitle, String genre, LocalDate releaseDate, String country, short duration, short minAge);
}
