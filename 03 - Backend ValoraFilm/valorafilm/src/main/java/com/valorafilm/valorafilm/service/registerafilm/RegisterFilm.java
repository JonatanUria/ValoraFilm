package com.valorafilm.valorafilm.service.registerafilm;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface RegisterFilm {
    void registerFilm(int userId, String filmTitle, String genre, LocalDate releaseDate, String country, int duration, short minAge) throws Exception;
}
