package com.valorafilm.valorafilm.controller.valoraFilmControllers;


import com.valorafilm.valorafilm.service.deleteafilm.impl.DeleteFilmImpl;
import com.valorafilm.valorafilm.service.obtainafilm.impl.ObtainAFilmImpl;
import com.valorafilm.valorafilm.service.obtainafilm.model.ObtainAFilmResponse;
import com.valorafilm.valorafilm.service.obtainfilms.impl.ObtainFilmsImpl;
import com.valorafilm.valorafilm.service.obtainfilms.model.ObtainFilmsResponse;
import com.valorafilm.valorafilm.service.obtainsynopsis.impl.ObtainSynopsisImpl;
import com.valorafilm.valorafilm.service.obtainsynopsis.model.ObtainSynopsisResponse;
import com.valorafilm.valorafilm.service.registerafilm.impl.RegisterFilmImpl;
import com.valorafilm.valorafilm.service.registerafilm.model.RequestRegisterFilm;
import com.valorafilm.valorafilm.service.registerasynopsis.impl.RegisterSynopsisImpl;
import com.valorafilm.valorafilm.service.registerasynopsis.model.RequestRegisterSynopsis;
import com.valorafilm.valorafilm.service.updateafilm.impl.UpdateFilmImpl;
import com.valorafilm.valorafilm.service.updateafilm.model.RequestUpdateFilm;
import com.valorafilm.valorafilm.service.updateasynopsis.impl.UpdateSynopsisImpl;
import com.valorafilm.valorafilm.service.updateasynopsis.model.RequestUpdateSynopsis;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class FilmController {


    @Autowired
    private RegisterSynopsisImpl registerSynopsis;
    @Autowired
    private RegisterFilmImpl registerFilm;
    @Autowired
    private ObtainFilmsImpl obtainFilms;
    @Autowired
    private ObtainSynopsisImpl obtainSynopsis;

    @Autowired
    private ObtainAFilmImpl obtainAFilm;
    @Autowired
    private UpdateSynopsisImpl updateSynopsis;
    @Autowired
    private UpdateFilmImpl updateFilm;
    @Autowired
    private DeleteFilmImpl deleteFilm;


    @PostMapping("/newfilm")
    public void registerFilm(@Valid @RequestBody RequestRegisterFilm request) throws Exception {
        System.out.println("la identidad del usuario " + request.getUserId());
        System.out.println("El titulo de la pelicula es " + request.getFilmTitle());
        System.out.println("El genero de la pelicula es " + request.getGenre());
        System.out.println("La fecha de lanzamiento de la pelicula es " + request.getReleaseDate());
        System.out.println("El país de la pelicula es " + request.getCountry());
        System.out.println("La duracion de la pelicula es " + request.getDuration());
        System.out.println("La edad minima para ver la pelicula es " + request.getMinAge());

        registerFilm.registerFilm(request.getUserId(), request.getFilmTitle(), request.getGenre(), request.getReleaseDate(), request.getCountry(), request.getDuration(), request.getMinAge());

        log.info("La película ha sido de alta correctamente.");
    }

    @PostMapping("/newsynopsis/{filmId}")
    public void registerSynopsis(@PathVariable int filmId, @Valid @RequestBody RequestRegisterSynopsis request) throws Exception {
        System.out.println("El id de la película es " + filmId);
        System.out.println("La sinopsis de la película es " + request.getSynopsis());
        registerSynopsis.registerSynopsis(filmId, request.getSynopsis());

        log.info("la sinopsis para la pelicula " + filmId + "ha sido dada de alta correctamente.");
    }


    @GetMapping("/obtainfilms")
    public List<ObtainFilmsResponse> obtainFilms() {
        return obtainFilms.obtainFilms();
    }

    @GetMapping("/obtainsynopsis")
    public List<ObtainSynopsisResponse> obtainSynopsis() {
        return obtainSynopsis.obtainSynopsis();
    }


    @GetMapping("/obtainafilm/{filmId}")
    public ObtainAFilmResponse obtainAFilmByID(@PathVariable int filmId) {
        return obtainAFilm.obtainFilm(filmId);

    }

    @PutMapping("/updatesynopsis/{filmId}")
    public void updateSynopsis(@PathVariable int filmId, @Valid @RequestBody RequestUpdateSynopsis request) {
        System.out.println(filmId);
        System.out.println(request.getSynopsis());

        updateSynopsis.updateSynopsis(filmId, request.getSynopsis());

        log.info("La sinopsis para la pelicula " + filmId + "ha sido modificada correctamente.");
    }

    @PutMapping("/updatefilm/{filmId}")
    public void updateFilm(@PathVariable int filmId, @Valid @RequestBody RequestUpdateFilm request) {
        System.out.println(filmId);
        System.out.println(request.getFilmTitle());
        System.out.println(request.getGenre());
        System.out.println(request.getReleaseDate());
        System.out.println(request.getCountry());
        System.out.println(request.getReleaseDate());
        System.out.println(request.getDuration());
        System.out.println(request.getMinAge());

        updateFilm.updateFilm(filmId, request.getFilmTitle(), request.getGenre(), request.getReleaseDate(), request.getCountry(), request.getDuration(), request.getMinAge());

        log.info("Los datos de la película " + filmId + "han sido modificados correctamente.");


    }

    @DeleteMapping("/deletefilm/{filmId}")
    public void deleteFilm(@PathVariable int filmId) {
        System.out.println(filmId);

        deleteFilm.deleteFilm(filmId);

        log.info("La película ha sido eliminada correctamente.");
    }


}
