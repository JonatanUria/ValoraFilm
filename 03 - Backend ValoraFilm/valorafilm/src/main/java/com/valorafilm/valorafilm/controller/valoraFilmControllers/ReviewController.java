package com.valorafilm.valorafilm.controller.valoraFilmControllers;

import com.valorafilm.valorafilm.service.deleteareview.impl.DeleteReviewImpl;
import com.valorafilm.valorafilm.service.deleteareview.model.RequestDeleteReview;
import com.valorafilm.valorafilm.service.obtainreviews.impl.ObtainReviewsImpl;
import com.valorafilm.valorafilm.service.obtainreviews.model.ObtainReviewsResponse;
import com.valorafilm.valorafilm.service.registerareview.impl.RegisterReviewImpl;
import com.valorafilm.valorafilm.service.registerareview.model.RequestRegisterReview;
import com.valorafilm.valorafilm.service.updateareview.impl.UpdateReviewImpl;
import com.valorafilm.valorafilm.service.updateareview.model.RequestUpdateReview;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ReviewController {
    @Autowired
    private RegisterReviewImpl registerReview;
    @Autowired
    private ObtainReviewsImpl obtainReviews;
    @Autowired
    private UpdateReviewImpl updateReview;
    @Autowired
    private DeleteReviewImpl deleteReview;

    @PostMapping("/newreview/{filmId}")
    public void registerReview(@PathVariable int filmId, @Valid @RequestBody RequestRegisterReview request) {
        System.out.println("El id de la película es " + filmId);
        System.out.println("El id del usuario es " + request.getUserId());
        System.out.println("La reseña crítica del usuario es " + request.getReview());
        System.out.println("La valoración del usuario es " + request.getUserScore());

        registerReview.registerReview(filmId, request.getUserId(), request.getReview(), request.getUserScore());

        log.info("La critica realizada por " + request.getUserId() + " para la pelicula " + filmId + "se ha dado de alta correctamente.");
    }

    @GetMapping("/obtainreviews")
    public List<ObtainReviewsResponse> obtainReviews() {
        return obtainReviews.obtainReviews();
    }

    @PutMapping("/updatereview/{filmId}")
    public void updateReview(@PathVariable int filmId, @Valid @RequestBody RequestUpdateReview request) {
        System.out.println(filmId);
        System.out.println(request.getUserId());
        System.out.println(request.getReview());
        System.out.println(request.getUserScore());

        updateReview.updateReview(filmId, request.getUserId(), request.getReview(), request.getUserScore());

        log.info("Los datos de la critica realizada por " + request.getUserId() + "para la pelicula " + filmId + " se han modificado correctamente.");


    }

    @DeleteMapping("/deletereview/{filmId}")
    public void deleteReview(@PathVariable int filmId, @Valid @RequestBody RequestDeleteReview request) {
        System.out.println(filmId);
        System.out.println(request.getUserId());

        deleteReview.deleteReview(filmId, request.getUserId());

        log.info("La critica ha sido eliminada correctamente.");
    }
}
