package com.esgi.jeeproject.vibecritical.domain.service.Rating;

import com.esgi.jeeproject.vibecritical.domain.entities.Rating.Rating;

import java.util.List;

public interface RatingService {
    Rating saveRating(Rating rating);

    Rating getRatingById(Long ratingId);

    List<Rating> getRatings();

}
