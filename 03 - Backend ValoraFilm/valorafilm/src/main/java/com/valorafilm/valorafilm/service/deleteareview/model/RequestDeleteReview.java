package com.valorafilm.valorafilm.service.deleteareview.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestDeleteReview {

    @NotNull
    private Integer userId;
}
