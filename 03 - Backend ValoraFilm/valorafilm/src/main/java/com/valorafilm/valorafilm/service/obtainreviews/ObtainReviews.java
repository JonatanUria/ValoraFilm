package com.valorafilm.valorafilm.service.obtainreviews;

import com.valorafilm.valorafilm.database.entities.Critica;
import com.valorafilm.valorafilm.service.obtainreviews.model.ObtainReviewsResponse;

import java.util.List;

public interface ObtainReviews {
    List<ObtainReviewsResponse> obtainReviews();
}
